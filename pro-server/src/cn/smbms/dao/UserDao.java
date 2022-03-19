package cn.smbms.dao;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao{

    /*
     *管理员登录
     */
    public User findUser(@Param("userName") String userName, @Param("userPassword") String userPassword);

    /**
     * 修改密码
     */
    public Integer updateUser(User User);


    /**
     * 查询管理员是否存在
     */
    public User findUsersByUsername(String userName);
}
