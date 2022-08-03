package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.bean.SysUser;
import cn.edu.guet.weappdemo.bean.SysUserRole;

import java.util.List;
import java.util.Set;

/**
 * 用户管理
 *
 * @Author Liwei
 * @Date 2021-08-13 18:03
 */
public interface SysUserService {

    List<SysUser> findUserList();//查找用户列表

    int getUser(String id);//根据id查询用户

    Set<String> findPermissions(String userName);

    SysUser findByName(String username);

    List<SysUserRole> findUserRoles(Long userId);

    //新增用户
    int insertUser(String name,String nickName,String email,String mobile,String password,String deptId,String roleId);

    //根据id修改用户
    int editUser(Long id,String name,String nick_name,String email,String mobile,String password,Long deptId,Long roleId);

    //删除用户
    int deleteUser(Long id);
}
