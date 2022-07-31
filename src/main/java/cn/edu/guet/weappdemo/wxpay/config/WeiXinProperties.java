package cn.edu.guet.weappdemo.wxpay.config;

import cn.edu.guet.weappdemo.wxpay.utils.FileUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Data
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "wx.pay")
@Primary //覆盖 当有多个这个的WxPayProperties实现类 注入这个
public class WeiXinProperties {

    /** appId ： 微信公众号或者小程序等的appid */
    private String appId;
    /** appSecret ： 应用密钥 */
    private String appSecret;
    /** mchId ： 微信支付商户号 */
    private String mchId;
    /** mchKey ： 微信支付商户密钥 */
    private String mchKey;
    /** mchKey ： 商户证书目录 */
    private String keyPath = FileUtil.getResourcesPath()+ "refund_certificate/apiclient_cert.p12";
}
