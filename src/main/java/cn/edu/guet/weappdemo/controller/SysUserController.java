package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.bean.SysUser;
import cn.edu.guet.weappdemo.bean.UserBean;
import cn.edu.guet.weappdemo.bean.insertUserBean;
import cn.edu.guet.weappdemo.http.HttpResult;
import cn.edu.guet.weappdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 用户控制器
 *
 * @Author Liwei
 * @Date 2021-08-17 07:15
 */
@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        System.out.println("查找权限："+name);
        return HttpResult.ok(sysUserService.findPermissions(name));
    }

    /**
     *获取用户列表
     */
    @GetMapping(value = "/findUserList")
    public HttpResult findUserList() {
        System.out.println("查找用户列表");
        return HttpResult.ok(sysUserService.findUserList());
    }

    /*
    根据id查询用户信息
     */
    @GetMapping(value = "/getUser")
    public HttpResult getUser(@RequestParam String id) {
        System.out.println("查找用户的id："+id);
        return HttpResult.ok(sysUserService.getUser(id));
    }

    /**
     * 新增用户
     */
    @PostMapping(value = "/insertUser")
//    public HttpResult insertUser(String id, String name, String nickName, String email, String mobile, String password, String deptId, String roleId) {
    public HttpResult insertUser(@RequestBody insertUserBean insertUser){
//    public HttpResult insertUser(@RequestBody String name){
        System.out.println("新增用户："+insertUser.getName());
        System.out.println("新增用户："+insertUser.getMobile());
        return HttpResult.ok(sysUserService.insertUser(insertUser.getName(),insertUser.getNickName(),insertUser.getEmail(),insertUser.getMobile(),insertUser.getPassword(),insertUser.getDeptId(),insertUser.getRoleId()));
//        return HttpResult.ok("ssssss");
    }

    /*
    根据用户名称修改用户信息
     */
    @PostMapping(value = "/editUser")
    public HttpResult editUser(@RequestBody UserBean userBean) {

//    public HttpResult editUser(@RequestBody String id) {
//        System.out.println("kkkk:"+id);
        System.out.println(userBean.getId());
        System.out.println(userBean.getName());
        return HttpResult.ok(sysUserService.editUser(userBean.getId(),userBean.getName(),userBean.getNickName(),userBean.getEmail(),userBean.getMobile(),userBean.getPassword(),userBean.getDeptId(),userBean.getRoleId()));
    }

    //根据id删除用户
    @PostMapping(value = "/deleteUser")
    public HttpResult deleteUser(@RequestBody Long id) {
        System.out.println("删除用户的id："+id);
        return HttpResult.ok(sysUserService.deleteUser(id));
    }

}
