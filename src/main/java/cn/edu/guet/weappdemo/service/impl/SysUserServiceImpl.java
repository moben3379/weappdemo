package cn.edu.guet.weappdemo.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.edu.guet.weappdemo.bean.SysMenu;
import cn.edu.guet.weappdemo.bean.SysRole;
import cn.edu.guet.weappdemo.bean.SysUser;
import cn.edu.guet.weappdemo.bean.SysUserRole;
import cn.edu.guet.weappdemo.mapper.SysRoleMapper;
import cn.edu.guet.weappdemo.mapper.SysUserMapper;
import cn.edu.guet.weappdemo.mapper.SysUserRoleMapper;
import cn.edu.guet.weappdemo.service.SysMenuService;
import cn.edu.guet.weappdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Liwei
 * @Date 2021-08-13 18:12
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public SysUser findByName(String name) {
        SysUser sysUser = sysUserMapper.findByName(name);
        if (sysUser != null) {
            List<SysUserRole> userRoles = findUserRoles(sysUser.getId());
            sysUser.setUserRoles(userRoles);
            sysUser.setRoleNames(getRoleNames(userRoles));
            return sysUser;
        }
        return null;
    }

    private String getRoleNames(List<SysUserRole> userRoles) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<SysUserRole> iter = userRoles.iterator(); iter.hasNext(); ) {
            SysUserRole userRole = iter.next();
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(userRole.getRoleId());
            if (sysRole == null) {
                continue;
            }
            sb.append(sysRole.getRemark());
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return sysUserRoleMapper.findUserRoles(userId);
    }


    /*
    ??????????????????
     */
    @Override
    public List<SysUser> findUserList() {
        return sysUserMapper.findUserList();
    }

    /*
    ??????id????????????
     */
    @Override
    public int getUser(String id) {
        return sysUserMapper.getUser(id);
    }

    /*
    ????????????
     */
    @Override
    public int insertUser(String name, String nickName, String email, String mobile, String password, String deptId, String roleId) {
        int insertUserList=sysUserMapper.insertUser(name, nickName, email, mobile, password, deptId);

        String id=sysUserMapper.searchUserIdByName(name);//?????????????????????????????????id

        int insertRoleList=sysUserMapper.insertUserRole(id,roleId);
        return insertUserList;
    }

    /*
    ????????????
     */
    @Override
    public int editUser(Long id, String name, String nick_name, String email, String mobile, String password, Long deptId, Long roleId) {
//    public int editUser(String id){
        int updateUser=sysUserMapper.editUser(id,name,nick_name,email,mobile,password,deptId);
        int updateUserRole=sysUserMapper.editUserRole(id,roleId);
    return sysUserMapper.editUser(id,name,nick_name,email,mobile,password,deptId);
    }

    //????????????
    @Override
    public int deleteUser(Long id) {
        return sysUserMapper.deleteUser(id);
    }


    @Override
    public Set<String> findPermissions(String userName) {
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.findByUser(userName);
        for (SysMenu sysMenu : sysMenus) {
            if (sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }
}
