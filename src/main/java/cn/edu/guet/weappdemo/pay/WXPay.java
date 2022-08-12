package cn.edu.guet.weappdemo.pay;


import cn.edu.guet.weappdemo.bean.UserPayBean;
import cn.edu.guet.weappdemo.config.AppConfig;
import cn.edu.guet.weappdemo.http.HttpResult;
import cn.edu.guet.weappdemo.sdk.WXPayUtil;
import cn.edu.guet.weappdemo.util.DateUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


@RestController
public class WXPay {

    @Autowired
    private AppConfig appConfig;

    private static Log log = LogFactory.getLog(WXPay.class);

    private static final String PAY_SUCCESS = "SUCCESS";
    private static final String PAY_USERPAYING = "USERPAYING";

     /*
        统一下单支付
     */
    @PostMapping("pay")
    public HttpResult unifiedOrder(@RequestBody UserPayBean userPayBean) throws Exception {

        MyConfig config = null;
        cn.edu.guet.weappdemo.sdk.WXPay wxpay = null;
        try {
            config = new MyConfig();
            wxpay = new cn.edu.guet.weappdemo.sdk.WXPay(config);
        } catch (Exception e) {
            e.printStackTrace();
        }



        //生成的随机字符串
        String nonce_str = WXPayUtil.generateNonceStr();
        //获取客户端的ip地址
        //获取本机的ip地址
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String spbill_create_ip = addr.getHostAddress();

        //支付金额，需要转成字符串类型，否则后面的签名会失败
        float price_f=Float.valueOf(userPayBean.getPrice())*100;
        int count=Integer.valueOf(userPayBean.getAmount());
        int total=(int)price_f*count;
        String total_fee =String.valueOf(total);//金额

        //商户订单号
        String out_trade_no = WXPayUtil.generateNonceStr();

        //统一下单接口参数
        SortedMap<String, String> data = new TreeMap<String, String>();
        data.put("appid", appConfig.getApp_id());
        data.put("body", userPayBean.getBody());
        data.put("mch_id", appConfig.getMch_id());

        // 回调接口，必须是一个域名，不能使用IP
        // 腾讯会自动调用你（程序自己提供的接口）的接口，给你发送支付结果的数据，数据格式：xml格式
        data.put("notify_url", appConfig.getNotify_url());
        data.put("out_trade_no", out_trade_no);//交易号
        data.put("spbill_create_ip", spbill_create_ip);//下单的电脑IP地址
        data.put("trade_type", "NATIVE");//支付类型
        data.put("total_fee", total_fee);
        String attach="id,"+userPayBean.getId()+";price,"+userPayBean.getPrice()+";amount,"+userPayBean.getAmount()+";";
        data.put("attach",attach);

        try {
            Map<String, String> rMap = wxpay.unifiedOrder(data);
            System.out.println("统一下单接口返回: " + rMap);
            createQRCode(rMap);//生成二维码
        } catch (Exception e) {
            e.printStackTrace();
        }

        return HttpResult.ok(wxpay.unifiedOrder(data));
    }

    public static void createQRCode(Map<String, String> map) throws Exception {

        File outputFile = new File("./" + File.separator + "new.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        String url = map.get("code_url");
        System.out.println("生成二维码的url：" + url);
        try {
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 200, 200, hints);

            MatrixToImageWriter.writeToStream(bitMatrix, "jpg", fileOutputStream);
        } catch (Exception e) {
            throw new Exception("生成二维码失败！");
        } finally {
            fileOutputStream.close();
        }
    }
}
