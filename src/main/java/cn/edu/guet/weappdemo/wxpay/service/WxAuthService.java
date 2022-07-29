package cn.edu.guet.weappdemo.wxpay.service;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.edu.guet.weappdemo.wxpay.entity.WxLoginEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
@Slf4j
public class WxAuthService {

    private final WxMaService wxMaService;


    /**
     *  微信授权获取用户信息
     * @param entity
     * @return
     * @throws WxErrorException
     */
    public WxLoginEntity wxAuth(WxLoginEntity entity) throws WxErrorException {

        // 获取微信用户session
        WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(entity.getCode());
        Assert.isNull(session,"获取微信Session失败");
        Assert.isNull(session.getOpenid(),"获取openid失败");


        // 解密手机号码信息
        WxMaPhoneNumberInfo wxMaPhoneNumberInfo = wxMaService.getUserService().getPhoneNoInfo(session.getSessionKey(),
                entity.getEncryptedData(), entity.getIv());
        if (wxMaPhoneNumberInfo == null || StringUtils.isEmpty(wxMaPhoneNumberInfo.getPhoneNumber())){
            throw new RuntimeException("获取用户手机号失败");
        }
        log.info(String.format("============用户登录注册获取微信用户信息===========> openId=%s, nickName=%s,phone=%s", session.getOpenid(), entity.getNickName(),wxMaPhoneNumberInfo.getPhoneNumber()));
        //封装返回用户信息
        WxLoginEntity wxLoginEntity = WxLoginEntity.builder()
                .avatar(entity.getAvatar())
                .nickName(entity.getNickName())
                .openId(session.getOpenid())
                .gender(0)
                .phoneNumber(wxMaPhoneNumberInfo.getPhoneNumber())
                .build();

        return wxLoginEntity;
    }

}
