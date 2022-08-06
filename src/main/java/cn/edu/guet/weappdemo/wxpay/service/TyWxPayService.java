package cn.edu.guet.weappdemo.wxpay.service;

import cn.edu.guet.weappdemo.wxpay.entity.WxEntPayEntity;
import cn.edu.guet.weappdemo.wxpay.entity.WxPayEntity;
import cn.edu.guet.weappdemo.wxpay.entity.WxRefundEntity;
import cn.edu.guet.weappdemo.wxpay.utils.DateUtils;
import com.github.binarywang.wxpay.bean.entpay.EntPayRequest;
import com.github.binarywang.wxpay.bean.entpay.EntPayResult;
import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @ClassName 公众号支付WxPayService
 * @Author LWL
 * @Date 2022-03-17
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class TyWxPayService {

    private final WxPayService wxPayService;

    public Object wxPay(WxPayEntity entity) {
        /**
         * 处理内部业务，校验订单等
         */
        final WxPayUnifiedOrderRequest wxPayUnifiedOrderRequest = WxPayUnifiedOrderRequest.newBuilder()
                //调起支付的人的 openId
                .openid(entity.getOpenId(/*这里写openid*/))/*这里写openid*/
                //订单编号
                .outTradeNo(entity.getOrderNo(/*自己生成的订单号*/))/*自己生成的订单号*/
                //小程序支付
                .tradeType(WxPayConstants.TradeType.JSAPI)
                //订单金额(单位是分)BaseWxPayRequest.yuanToFen()这个方法是将元转分
                .totalFee(BaseWxPayRequest.yuanToFen(entity.getTotalFee().toString()))//"这里写支付金额"
                //商品描述
                .body(entity.getBody(/*描述*/))/*描述*/
                //获取本地IP
                .spbillCreateIp(entity.getIp(/*客户端ip*/))/*客户端ip*/
                //回调的 URL 地址
                .notifyUrl("https://g2.juntaitec.cn")/*这里写支付成功后微信的微信接口*/
                .timeExpire(DateUtils.format(DateUtils.computeDate(LocalDateTime.now(/*支付过期时间*/), 10, DateUtils.Type.MINUTE), "yyyyMMddHHmmss"))//支付过期时间
                .timeStart(DateUtils.dateTimeNow())//当前时间
                .build();
        wxPayUnifiedOrderRequest.setSignType(WxPayConstants.SignType.MD5);

        Object order = null;
        try {
            order = wxPayService.createOrder(wxPayUnifiedOrderRequest);
        } catch (WxPayException e) {
            throw new RuntimeException(e.getErrCodeDes());
        }
        return order;
    }

    /**
     * 退款
     * @throws WxPayException
     */
    public void refundOrder(WxRefundEntity entity) {

        WxPayRefundRequest wxPayRefundRequest = WxPayRefundRequest.newBuilder()
                //订单总金额
                .totalFee(BaseWxPayRequest.yuanToFen(entity.getTotalFee().toString()))
                //订单编号
                .outTradeNo(entity.getOrderNo())
                //退款编号
                .outRefundNo(entity.getOutRefundNo())
                //退款金额
                .refundFee(BaseWxPayRequest.yuanToFen(entity.getRefundFee().toString()))
                //回调接口
                .notifyUrl("https://g2.juntaitec.cn")
                .build();

        try {
            wxPayService.refund(wxPayRefundRequest);
        } catch (WxPayException e) {
            throw new RuntimeException(e.getErrCodeDes());
        }
    }
    /**
     * 企业打款
     */
    public EntPayResult entPay(WxEntPayEntity entity) {

        EntPayRequest entPayRequest = EntPayRequest.newBuilder()
                .openid(entity.getOpenId())
                //商户订单号，需保持唯一性(只能是字母或者数字，不能包含有其它字符)
                .partnerTradeNo(entity.getPartnerTradeNo())
                //是否检验真实姓名  NO_CHECK：不校验真实姓名 FORCE_CHECK：强校验真实姓名
                .checkName(entity.getCheckName())
                //收款用户真实姓名。如果check_name设置为FORCE_CHECK，则必填用户真实姓名 如需电子回单，需要传入收款用户姓名
                .reUserName(entity.getReUserName())
                //转账金额，单位为分
                .amount(BaseWxPayRequest.yuanToFen(entity.getAmount().toString()))
                //付款备注，必填。注意：备注中的敏感词会被转成字符*
                .description(entity.getDescription())
                //该IP同在商户平台设置的IP白名单中的IP没有关联，该IP可传用户端或者服务端的IP。
                .spbillCreateIp(entity.getSpbillCreateIp())
                .build();

        try {
            return wxPayService.getEntPayService().entPay(entPayRequest);
        } catch (WxPayException e) {
            throw new RuntimeException(e.getErrCodeDes());
        }
    }

}
