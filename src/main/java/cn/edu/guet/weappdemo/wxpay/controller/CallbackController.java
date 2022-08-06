package cn.edu.guet.weappdemo.wxpay.controller;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * 微信回调接口微信回调接口
 */
@Slf4j
@RestController
@RequestMapping("/mini/callback")
@RequiredArgsConstructor
public class CallbackController {

    private final WxPayService wxPayService;


    /**
     * 微信支付回调接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/payNotify")
    public String payNotify(HttpServletRequest request) {
        try {
            String xmlResult = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            WxPayOrderNotifyResult notifyResult = wxPayService.parseOrderNotifyResult(xmlResult);
            // 结果正确 outTradeNo
            String orderId = notifyResult.getOutTradeNo();
            String tradeNo = notifyResult.getTransactionId();
            String totalFee = BaseWxPayResult.fenToYuan(notifyResult.getTotalFee());
            //支付成功
            if("SUCCESS".equals(notifyResult.getResultCode())) {
                log.info("================>微信支付回调：订单号<{}>",orderId);
                //自己处理订单的业务逻辑，需要判断订单是否已经支付过，否则可能会重复调用

            }
            return WxPayNotifyResponse.success("成功");
        } catch (Exception e) {
            log.error("微信回调结果异常,异常原因{}", e.getMessage());
            return WxPayNotifyResponse.success("code:"+9999+"微信回调结果异常,异常原因:"+e.getMessage());
        }
    }

    /**
     * 微信退款回调接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/refundNotify")
    public String refundNotify(HttpServletRequest request) {
        try {
            String xmlResult = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            WxPayRefundNotifyResult wxPayRefundNotifyResult = wxPayService.parseRefundNotifyResult(xmlResult);
            String outTradeNo = wxPayRefundNotifyResult.getReqInfo().getOutTradeNo();
            Integer refundFee = wxPayRefundNotifyResult.getReqInfo().getRefundFee();
            String outRefundNo = wxPayRefundNotifyResult.getReqInfo().getOutRefundNo();

            //退款成功
            if("SUCCESS".equals(wxPayRefundNotifyResult.getReqInfo().getRefundStatus())) {



            }
            return WxPayNotifyResponse.success("成功");
        } catch (Exception e) {
            log.error("微信回调结果异常,异常原因{}", e.getMessage());
            return WxPayNotifyResponse.success("code:"+9999+"微信回调结果异常,异常原因:"+e.getMessage());
        }
    }

}
