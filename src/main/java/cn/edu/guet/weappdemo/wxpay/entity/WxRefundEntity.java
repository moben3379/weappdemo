package cn.edu.guet.weappdemo.wxpay.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 微信退款参数
 */
@Data
@AllArgsConstructor
@Builder
public class WxRefundEntity {

    //退款订单号
    private String outRefundNo;

    //原支付订单号
    private String orderNo;

    //订单金额
    private BigDecimal totalFee;

    //退款金额
    private BigDecimal refundFee;

}
