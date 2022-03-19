package cn.smbms.service;

import cn.smbms.pojo.User;

public interface UserService {




    /**
     * 登录
     * @param userName
     * @param userPassword
     * @return
     */
    public User findUser(String userName, String userPassword);


    /**
     * 修改密码
     */
    public void updateUser(String userName, String newPassword);


    /*
    *判断管理员是否存在
     */
    public boolean isUserExist(String userName);

    //根据提供的用户名拿密码
    public String getPasswordByUsername(String userName);
}
