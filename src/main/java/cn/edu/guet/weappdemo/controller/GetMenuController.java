package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.bean.FoodMenu;
import cn.edu.guet.weappdemo.http.HttpResult;
import cn.edu.guet.weappdemo.service.GetMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 旨意查询菜单所有信息
 *
 * @Author Liwei
 * @Date 2021-08-16 09:20
 */
@RestController
@RequestMapping("getmenu")
public class GetMenuController {

    @Autowired
    private GetMenuService getMenuService;

    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value = "/findMenuInformation")
    public HttpResult findMenuInformation() {
        System.out.println("********************导通查询菜单通道********************");
        List<FoodMenu> getMenus = getMenuService.findAll();
        System.out.println(getMenus);
        return HttpResult.ok(getMenus);
    }

    @PreAuthorize("hasAuthority('sys:menu:view')")

    @GetMapping(value = "/alterMenuInformation")
//    String username, String password, HttpServletRequest request
    public void alterMenuInformation(@RequestParam Integer Id, @RequestParam String Name, @RequestParam double Price, @RequestParam String Form, @RequestParam Integer Count, @RequestParam String Icon, @RequestParam String Detail, HttpServletRequest request) {
        System.out.println("********************修改的数据向数据库输送********************");
        System.out.println(Id+Name+Price+Form+Count+Icon+Detail);
        getMenuService.AlterFoodMenu(Id,Name,Price,Form,Count,Icon,Detail);
//        return HttpResult.ok(getMenus);
    }


    @PreAuthorize("hasAuthority('sys:menu:view')")
    @PostMapping(value ="/searchMenu")
    public HttpResult searchMenu(@RequestBody String searchKey){
        System.out.println(searchKey);
        return HttpResult.ok(getMenuService.searchMenu(searchKey));
    }

    @GetMapping(value = "/addMenuInformation")//新增菜品数据
    public void addMenuInformation(@RequestParam Integer Id, @RequestParam String Name, @RequestParam double Price, @RequestParam String Form, @RequestParam Integer Count, @RequestParam String Icon, @RequestParam String Detail, HttpServletRequest request){
        System.out.println("新增的菜品ID为："+Id+Name+Price+Form+Count+Icon+Detail);
        getMenuService.AddFoodMenu(Id, Name, Price, Form, Count, Icon, Detail);
    }
    @PostMapping(value = "deleteMenu")
    public void deleteMenu(@RequestBody String Id) {
        getMenuService.deleteMenu(Id);

    }
}
