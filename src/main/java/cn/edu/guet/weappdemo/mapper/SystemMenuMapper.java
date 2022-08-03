package cn.edu.guet.weappdemo.mapper;

import cn.edu.guet.weappdemo.bean.SystemMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jyy
 * @date 2022/8/2 9:36
 */
@Mapper
public interface SystemMenuMapper {
    List<SystemMenu> getSystemMenuList();

    int addMenu(@Param("parentId") Long parentId, @Param("name") String name, @Param("url") String url,@Param("perms") String perms,@Param("type") Integer type, @Param("icon") String icon, @Param("orderNum") Integer orderNum);

    int updateMenu(@Param("id") Long id,@Param("parentId") Long parentId, @Param("name") String name, @Param("url") String url,@Param("perms") String perms,@Param("type") Integer type, @Param("icon") String icon, @Param("orderNum") Integer orderNum) ;

    int deleteMenu(@Param("id") Long id);
}
