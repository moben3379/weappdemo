package cn.edu.guet.weappdemo.mapper;

import cn.edu.guet.weappdemo.bean.UserInfomationBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WeChatMapper {
    int InsertWxUser(@Param("phone") String phone,@Param("address") String address,@Param("open_id") String openid);

    UserInfomationBean findWxUserByOpenid(String openid);

    int updataUserInfo(@Param("phone") String phone,@Param("address") String address,@Param("open_id") String openid);
}
