package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.bean.SystemMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jyy
 * @date 2022/8/2 9:28
 */
public interface SystemMenuService {
    List<SystemMenu> systemMenuList();

    int addMenu(Long parentId, String name, String url,String perms, Integer type, String icon, Integer orderNum);

    int updateMenu(Long id,Long parentId, String name, String url,String perms, Integer type, String icon, Integer orderNum);

    int deleteMenu(Long id);
}
