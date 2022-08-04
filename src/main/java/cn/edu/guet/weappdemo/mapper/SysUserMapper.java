package cn.edu.guet.weappdemo.mapper;

import java.util.List;

import cn.edu.guet.weappdemo.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Liwei
 * @Date 2021-08-13 17:50
 */
@Mapper
public interface SysUserMapper {

    List<SysUser> findUserList();

    int getUser(@Param(value = "id") String id);

    /**
     * 下面三个方法作为新增用户的一个事务执行
     * @param name
     * @param nickName
     * @param email
     * @param mobile
     * @param password
     * @param deptId
     * @return
     */
    //向用户表插入名称，昵称，邮箱，电话，密码和部门id
    int insertUser(@Param(value = "name") String name,@Param(value = "nickName") String nickName,@Param(value = "email") String email,@Param(value = "mobile") String mobile,@Param(value = "password") String password,@Param(value = "deptId") String deptId);
    //根据新增用户的名称获取自增的id
    String searchUserIdByName(@Param(value = "name") String name);
    //向sys_user_role表插入user_id和role_id
    int insertUserRole(@Param(value = "id") String user_id,@Param(value = "roleId") String roleId);

    SysUser findByName(@Param(value = "name") String name);


    /*
    修改用户
     */
    int editUser(@Param(value = "id") Long id,@Param(value = "name") String name,@Param(value = "nickName") String nick_name,@Param(value = "email") String email,@Param(value = "mobile") String mobile,@Param(value = "password") String password,@Param(value = "deptId") Long deptId);
    int editUserRole(@Param(value = "id") Long id,@Param(value = "roleId") Long roleId);

    /*
    删除用户
     */
    int deleteUser(@Param(value = "id") Long id);
}
