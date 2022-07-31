package cn.edu.guet.weappdemo.wxpay.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 微信授权参数
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WxLoginEntity implements Serializable {

    //用户登录凭证
    private String code;

    //加密用户数据
    private String encryptedData;

    //加密算法的初始向量
    private String iv;

    //昵称
    private String nickName;

    //头像
    private String avatar;

    //openid
    private String openId;

    //性别： 0：未知、1：男、2：女
    private Integer gender;

    //手机号
    private String phoneNumber;
}

