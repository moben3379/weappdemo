package cn.edu.guet.weappdemo.controller;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/wxapp/code2session")
public class WeChatController {
    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("login")
    public @ResponseBody String code2session(String code, HttpSession session){
        // 参数检查
        Assert.isTrue(StringUtils.isNotBlank(code), "必须提供code");

        // 调用接口
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx506a7af4825cb208&secret=0b89666bf2c72eaba1f9cd8a7d35fe55&js_code="+code+"&grant_type=authorization_code";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("appid", "wx506a7af4825cb208");
        paramMap.put("secret", "0b89666bf2c72eaba1f9cd8a7d35fe55");
        paramMap.put("code", code);

        System.out.println("code:" + code);

        String result = this.restTemplate.getForObject(url, String.class, paramMap);//获取openid、session_key
        JSONObject jsonObject = JSONObject.parseObject(result);//转为JSON格式

        String openid=jsonObject.getString("openid");
        String session_key=jsonObject.getString("session_key");

        System.out.println("openid:"+openid);
        System.out.println("session_key:"+session_key);

        String session_id=openid+session_key;

        session.setAttribute("3rd_session",session_id);
        System.out.println(session.getId());
        System.out.println(session.getAttribute("3rd_session"));
        return result;
    }



}
