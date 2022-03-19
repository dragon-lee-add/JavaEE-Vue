package cn.smbms.service;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String userName, String userPassword) {
        return userDao.findUser(userName,userPassword);
    }



    @Override
    public void updateUser(String userName, String newPassword) {
        User user = userDao.findUsersByUsername(userName);
        user.setUserName(userName);
        user.setUserPassword(newPassword);
        userDao.updateUser(user);

    }


    @Override
    //判断用户是否存在
    public boolean isUserExist(String userName) {
        if (userDao.findUsersByUsername(userName) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    //根据提供的用户名拿密码
    public String getPasswordByUsername(String userName) {
        return userDao.findUsersByUsername(userName).getUserPassword();
    }

}
