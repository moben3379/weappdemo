package cn.edu.guet.weappdemo.wxpay.config;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Slf4j
@Configuration
@ConditionalOnClass(WxPayService.class)//引入WxPayService这个类 下面两个才会实例化
@EnableConfigurationProperties(WeiXinProperties.class) //注入WxPayProperties类
@RequiredArgsConstructor
public class WxPayConfiguration {
    private final WeiXinProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public WxPayService wxPayService() {

        //实例payConfig 设置固定参数
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(StringUtils.trimToNull(this.properties.getAppId()));
        payConfig.setMchId(StringUtils.trimToNull(this.properties.getMchId()));
        payConfig.setMchKey(StringUtils.trimToNull(this.properties.getMchKey()));
//        payConfig.setSubAppId(StringUtils.trimToNull(this.properties.getSubAppId()));
//        payConfig.setSubMchId(StringUtils.trimToNull(this.properties.getSubMchId()));
        payConfig.setKeyPath(StringUtils.trimToNull(this.properties.getKeyPath()));

        // 可以指定是否使用沙箱环境
        payConfig.setUseSandboxEnv(false);

        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }

}
