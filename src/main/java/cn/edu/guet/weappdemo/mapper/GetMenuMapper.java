package cn.edu.guet.weappdemo.mapper;

import java.util.List;

import cn.edu.guet.weappdemo.bean.FoodMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Liwei
 * @Date 2021-08-13 17:50
 */
@Mapper
public interface GetMenuMapper {
    List<FoodMenu> findAll();

    void AlterFoodMenu(@Param(value = "Id") int Id,@Param(value = "Name") String Name,@Param(value = "Price") double Price,@Param(value = "Form") int Form,@Param(value = "Count") int Count,@Param(value = "Icon") String Icon,@Param(value = "Detail") String Detail,@Param(value = "Describe") String Describe);

    List<FoodMenu> searchMenu(String searchKey);


    void AddFoodMenu(@Param(value = "Id") int Id,@Param(value = "Name") String Name,@Param(value = "Price") double Price,@Param(value = "Form") int Form,@Param(value = "Count") int Count,@Param(value = "Icon") String Icon,@Param(value = "Detail") String Detail);


    int deleteMenu(String Id);


}




