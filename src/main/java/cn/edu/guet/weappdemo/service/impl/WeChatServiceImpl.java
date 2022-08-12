package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.bean.UserInfomationBean;
import cn.edu.guet.weappdemo.mapper.OrderListMapper;
import cn.edu.guet.weappdemo.mapper.WeChatMapper;
import cn.edu.guet.weappdemo.service.WxChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeChatServiceImpl implements WxChatService {

    @Autowired
    private WeChatMapper weChatMapper;


    @Override
    public int insertWxUser(String phone, String address, String open_id) {
        return weChatMapper.InsertWxUser(phone,address,open_id);
    }

    @Override
    public UserInfomationBean findWxUserByOpenid(String open_id) {
        return weChatMapper.findWxUserByOpenid(open_id);
    }

    @Override
    public int updataUserInfo(String phone, String address, String open_id) {
        return weChatMapper.updataUserInfo(phone,address,open_id);
    }
}
