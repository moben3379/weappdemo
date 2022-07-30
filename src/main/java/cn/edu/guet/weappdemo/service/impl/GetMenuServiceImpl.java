package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.bean.FoodMenu;
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
    public void AlterFoodMenu(Integer Id, String Name, double Price, String Form, Integer Count, String Icon, String Detail) {
        getMenuMapper.AlterFoodMenu(Id,Name,Price,Form,Count,Icon,Detail);
    }
}
