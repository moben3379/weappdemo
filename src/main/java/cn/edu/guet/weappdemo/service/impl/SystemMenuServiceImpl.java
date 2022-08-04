package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.bean.SystemMenu;
import cn.edu.guet.weappdemo.mapper.SystemMenuMapper;
import cn.edu.guet.weappdemo.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jyy
 * @date 2022/8/2 9:28
 */
@Service
public class SystemMenuServiceImpl implements SystemMenuService {

    @Autowired
    private SystemMenuMapper systemMenuMapper;

    @Override
    public List<SystemMenu> systemMenuList() {
        return systemMenuMapper.getSystemMenuList();
    }

    @Override
    public int addMenu(Long parentId, String name, String url,String perms, Integer type, String icon, Integer orderNum) {
        return systemMenuMapper.addMenu(parentId,name,url,perms,type,icon,orderNum);
    }

    @Override
    public int updateMenu(Long id,Long parentId, String name, String url,String perms, Integer type, String icon, Integer orderNum) {
        return systemMenuMapper.updateMenu(id,parentId,name,url,perms,type,icon,orderNum);
    }

    @Override
    public int deleteMenu(Long id) {
        return systemMenuMapper.deleteMenu(id);
    }
}
