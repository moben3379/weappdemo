package cn.edu.guet.weappdemo.wxpay.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 微信支付参数
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WxPayEntity {

    //用户openid
    private String openId;

    //商户订单号
    private String orderNo;

    //支付金额
    private BigDecimal totalFee;

    ///内容
    private String body;

    //ip
    private String ip;

    //code
    private String code;

}
