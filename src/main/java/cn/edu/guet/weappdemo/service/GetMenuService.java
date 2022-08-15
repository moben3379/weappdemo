package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.bean.FoodMenu;

import java.util.List;

public interface GetMenuService {
//    查询菜品所有信息
    List<FoodMenu> findAll();
//    修改菜品输入数据库
    void AlterFoodMenu(int Id, String Name, double Price, int Form, int Count, String Icon, String Detail, String Describe );


    List<FoodMenu> searchMenu(String searchKey);


    void AddFoodMenu(int Id, String Name, double Price, int Form, int Count, String Icon, String Detail);

    void deleteMenu(String Id);

}
