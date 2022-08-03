package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.http.HttpResult;
import cn.edu.guet.weappdemo.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jyy
 * @date 2022/8/2 9:12
 */
@RestController
public class SystemMenuController {
    @Autowired
    private SystemMenuService systemMenuService;

    @GetMapping("getSystemMenuList")//显示sys_menu里的内容
    public HttpResult getSystemMenuList() {
        return HttpResult.ok(systemMenuService.systemMenuList());
    }

    @GetMapping("menuAdd")//添加数据到sys_menu
    public int addMenu(Long parentId,String name,String url,String perms,Integer type,String icon,Integer orderNum){
        return systemMenuService.addMenu(parentId,name,url,perms,type,icon,orderNum);
    }

    @GetMapping("menuUpdate")//修改sys_menu里面的数据
    public int updateMenu(Long id,Long parentId,String name,String url,String perms,Integer type,String icon,Integer orderNum){
        return systemMenuService.updateMenu(id,parentId,name,url,perms,type,icon,orderNum);
    }

    @GetMapping("menuDelete")//删除sys_menu里的数据
    public int deleteMenu(Long id){
        System.out.println("要删除数据的id是："+id);
        return systemMenuService.deleteMenu(id);
    }
}
