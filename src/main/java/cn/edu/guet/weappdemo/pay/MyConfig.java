package cn.edu.guet.weappdemo.pay;

import cn.edu.guet.weappdemo.sdk.IWXPayDomain;
import cn.edu.guet.weappdemo.sdk.WXPayConfig;
import cn.edu.guet.weappdemo.sdk.WXPayConstants;

import java.io.*;

public class MyConfig extends WXPayConfig {

    private byte[] certData;

    public MyConfig() throws Exception {
//        String certPath = "/Users/liwei/IdeaProjects/wxpaydemo/src/main/resources/cert/apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
    }

    // 微信公众号的APPID
    public String getAppID() {
        return "wx506a7af4825cb208";
    }

    // 商户ID
    public String getMchID() {
        return "1623889015";
    }

    // 密钥
    public String getKey() {
        return "v2LZk95bXz6VPjQq9yOPg3wPCD3BKqcM";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo("api.mch.weixin.qq.com", false);
            }
        };
    }

}