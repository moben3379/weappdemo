package cn.edu.guet.weappdemo.wxpay.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 微信商家打款参数
 */
@Data
@AllArgsConstructor
@Builder
public class WxEntPayEntity {

    //用户openid
    private String openId;

    //订单号
    private String partnerTradeNo;

   //是否校验真实姓名
    private final String checkName = "FORCE_CHECK";

    //用户名
    private String reUserName;

    //金额
    private BigDecimal amount;

    //描述
    private String description;

    //ip
    private String spbillCreateIp;

}
