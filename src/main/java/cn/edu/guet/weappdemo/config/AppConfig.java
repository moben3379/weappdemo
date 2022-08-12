package cn.edu.guet.weappdemo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties( prefix = "wx.pay")
public class AppConfig {
    //微信公众号或者小程序等的appid
    private String app_id;

    //应用密钥
    private String app_secret;

    //微信支付商户号
    private String mch_id;

    //微信支付商户密钥
    private String mch_key;

    //微信支付回调地址
    private String notify_url;
}
