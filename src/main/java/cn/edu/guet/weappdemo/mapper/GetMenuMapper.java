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
    void AlterFoodMenu(@Param(value = "Id") Integer Id,@Param(value = "Name") String Name,@Param(value = "Price") double Price,@Param(value = "Form") String Form,@Param(value = "Count") Integer Count,@Param(value = "Icon") String Icon,@Param(value = "Detail") String Detail);
}



