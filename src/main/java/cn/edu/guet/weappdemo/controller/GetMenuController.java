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
public class GetMenuController {

    @Autowired
    private GetMenuService getMenuService;

    @GetMapping("findMenuInformation")
    public HttpResult findMenuInformation() {
        List<FoodMenu> getMenus = getMenuService.findAll();
        System.out.println("菜单信息："+getMenus);
        return HttpResult.ok(getMenus);
    }


    @GetMapping(value = "alterMenuInformation")
    public void alterMenuInformation(@RequestParam int Id, @RequestParam int Form,@RequestParam String Name, @RequestParam double Price,  @RequestParam int Count, @RequestParam String Icon, @RequestParam String Detail, HttpServletRequest request) {
        getMenuService.AlterFoodMenu(Id,Name,Price,Form,Count,Icon,Detail);

    }


    @PostMapping("searchMenu")
    public HttpResult searchMenu(@RequestBody String searchKey) {
        return HttpResult.ok(getMenuService.searchMenu(searchKey));
    }

    @GetMapping("addMenuInformation")//新增菜品数据
    public void addMenuInformation(@RequestParam int Id, @RequestParam String Name, @RequestParam double Price, @RequestParam int Form, @RequestParam int Count, @RequestParam String Icon, @RequestParam String Detail, HttpServletRequest request) {

        getMenuService.AddFoodMenu(Id, Name, Price, Form, Count, Icon, Detail);
    }

    @PostMapping("deleteMenu")

    public void deleteMenu(@RequestBody String Id) {
        getMenuService.deleteMenu(Id);
    }
}
