package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.bean.FoodMenu;
import cn.edu.guet.weappdemo.bean.OrderList;
import cn.edu.guet.weappdemo.mapper.GetMenuMapper;
import cn.edu.guet.weappdemo.service.GetMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMenuServiceImpl implements GetMenuService {

    @Autowired
    private GetMenuMapper getMenuMapper;

    @Override
    public List<FoodMenu> findAll() {
        return getMenuMapper.findAll();
    }

    @Override
    public void AlterFoodMenu(int Id, String Name, double Price, int Form, int Count, String Icon, String Detail) {
        System.out.println("服务层收到消息"+Id+Form+Name+Price+Count+Icon+Detail);
        getMenuMapper.AlterFoodMenu(Id,Name,Price,Form,Count,Icon,Detail);
    }


    @Override
    public List<FoodMenu> searchMenu(String searchKey) {
         return getMenuMapper.searchMenu(searchKey);
    }


    @Override
    public void AddFoodMenu(int Id, String Name, double Price, int Form, int Count, String Icon, String Detail) {
        getMenuMapper.AddFoodMenu(Id,Name,Price,Form,Count,Icon,Detail);
    }



    @Override
    public void deleteMenu(String Id) {
        getMenuMapper.deleteMenu(Id);
    }

}
