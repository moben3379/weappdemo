package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.config.AppConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/wxapp/code2session")
public class WeChatController {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("login")
    public @ResponseBody String code2session(String code, HttpSession session){
        // 参数检查
        Assert.isTrue(StringUtils.isNotBlank(code), "必须提供code");

        // 调用接口
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appConfig.getApp_id()+"&secret="+appConfig.getApp_secret()+"&js_code="+code+"&grant_type=authorization_code";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("appid", appConfig.getApp_id());
        paramMap.put("secret", appConfig.getApp_secret());
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


      /* @GetMapping("accessToken")
       public @ResponseBody String getAccessToken(String code){
           //请求Accesstoken
           String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appConfig.getApp_id()+"&secret="+appConfig.getApp_secret();
           Map<String, String> paramMap = new HashMap<>();
           paramMap.put("appid", appConfig.getApp_id());
           paramMap.put("secret", appConfig.getApp_secret());
           paramMap.put("grant_type", "client_credential");

           //获取AccessToken
           String result = this.restTemplate.getForObject(url, String.class, paramMap);//获取openid、session_key
           JSONObject jsonObject = JSONObject.parseObject(result);//转为JSON格式

           String accesstoken = jsonObject.getString("access_token");
           System.out.println("accesstoken---------------"+accesstoken);
           System.out.println("code+++++++++"+code);

           //用accessToken和code发送到微信后台换取用户手机号码
           String getPhone_Url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token="+accesstoken;
           MultiValueMap paramsMap = new LinkedMultiValueMap();
           paramsMap.add("code", code);
//         URI uri = restTemplate.postForLocation(getPhone_Url, paramsMap);
           ResponseEntity<String> responseEntity = restTemplate.postForEntity(getPhone_Url, paramsMap, String.class);

           System.out.println("电话号码等："+responseEntity);

           return null;
       }*/
}
