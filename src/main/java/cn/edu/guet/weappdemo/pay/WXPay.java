package cn.edu.guet.weappdemo.pay;

import cn.edu.guet.weappdemo.util.DateUtil;
import cn.edu.guet.weappdemo.sdk.WXPayUtil;
import com.github.binarywang.utils.qrcode.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class WXPay {

    private static Log log = LogFactory.getLog(WXPay.class);

    private static final String PAY_SUCCESS = "SUCCESS";
    private static final String PAY_USERPAYING = "USERPAYING";

    public static void main(String[] args) throws Exception {

        // 生成二维码，完成支付
        unifiedOrder();
        // 商家扫用户手机的条形码
        //scanCodeToPay("");

    }

    /**
     * 扫码支付
     *
     * @throws Exception
     */
    public static String scanCodeToPay(String auth_code) throws Exception {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String spbill_create_ip = addr.getHostAddress();

        MyConfig config = new MyConfig();
        cn.edu.guet.weappdemo.sdk.WXPay wxpay = new cn.edu.guet.weappdemo.sdk.WXPay(config);
        String out_trade_no = DateUtil.getCurrentTime();
        Map<String, String> map = new HashMap<>(16);
        map.put("attach", "订单额外描述");
        map.put("auth_code", auth_code);
        map.put("body", "小米手机");
        map.put("device_info", "桂电1号店");
        map.put("nonce_str", WXPayUtil.generateNonceStr());
        map.put("out_trade_no", out_trade_no);
        map.put("spbill_create_ip", spbill_create_ip);
        map.put("total_fee", "1");
        //生成签名
        String sign = WXPayUtil.generateSignature(map, config.getKey());
        map.put("sign", sign);
        String mapToXml = null;
        try {
            //调用微信的扫码支付接口
            Map<String, String> resp = wxpay.microPay(map);
            System.out.println("扫码支付结果：" + resp);
            mapToXml = WXPayUtil.mapToXml(resp);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("微信支付失败" + e);
        }
        return "";
    }

    /*
    下单：生成二维码
     */
    public static void unifiedOrder() {
        Map<String, String> resultMap = new HashMap();
        String openid = "ouR0E1oP5UGTEBce8jZ_sChfH26g";
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
        int total_fee = 1;//100分：1块钱
        //商品描述
        String body = "test";
        //商户订单号
        String out_trade_no = WXPayUtil.generateNonceStr();
        //统一下单接口参数
        SortedMap<String, String> data = new TreeMap<String, String>();
        data.put("appid", "wxd9a46e74fc279fcc");
        data.put("body", body);
        data.put("mch_id", "1623889015");
        // 回调接口，必须是一个域名，不能使用IP
        // 腾讯会自动调用你（程序自己提供的接口）的接口，给你发送支付结果的数据，数据格式：xml格式
        data.put("notify_url", "http://4774k86o55.zicp.fun/result");
        data.put("out_trade_no", out_trade_no);//交易号
        data.put("spbill_create_ip", spbill_create_ip);//下单的电脑IP地址
        data.put("trade_type", "NATIVE");//支付类型
        data.put("total_fee", String.valueOf(total_fee));
        String p="id,11112;price,0.01;amount,1;";
        data.put("attach",p);
        //data.put("openid", openid);

        try {
            Map<String, String> rMap = wxpay.unifiedOrder(data);
            System.out.println("统一下单接口返回: " + rMap);
            createQRCode(rMap);//生成二维码
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createQRCode(Map<String, String> map) throws Exception {

        File outputFile = new File("/Users/123/" + File.separator + "new.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        String url = map.get("code_url");
        System.out.println("生成二维码的url：" + url);
        try {
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 300, 300, hints);

            MatrixToImageWriter.writeToStream(bitMatrix, "jpg", fileOutputStream);
        } catch (Exception e) {
            throw new Exception("生成二维码失败！");
        } finally {
            fileOutputStream.close();
        }
    }
}