package cn.smbms.controller;

import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String login(Model model, String userName, String userPassword, HttpSession session) {
        // 通过账号和密码查询用户
        User user = userService.findUser(userName,userPassword);
        if(user != null){
            // 将用户对象添加到Session
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("userPassword", user.getUserPassword());
            // 跳转到主页面
            return "redirect:Index";
        }
        model.addAttribute("msg", "账号或密码错误，请重新输入！");
        // 返回到登录页面
        return "/Login";
    }

    /**
     *退出登录
     */
    @RequestMapping(value = "/loginOut.html", method = RequestMethod.POST)
    public String LoginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        /* 清除session */
        Enumeration attributeNames = request.getSession().getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            session.removeAttribute(attributeNames.nextElement().toString());
        }
        return "/Login";
    }



    /*
     * 修改
     */
    @RequestMapping(value = "/editPwd.html")
    public String modifyPassword(@RequestParam("userName") String userName,
                                 @RequestParam("userPassword") String userPassword,
                                 @RequestParam("newPassword") String newPassword, ModelMap model ){
        if (!userService.isUserExist(userName)) {
            model.addAttribute("msg", "用户名不存在！");
        } else {
            if (userPassword.equals(userService.getPasswordByUsername(userName))) {
                userService.updateUser(userName, newPassword);
                model.addAttribute("msg", "修改密码成功！");
            } else {
                model.addAttribute("msg", "密码错误！");
            }
        }
        return "/EditPwd";
    }

}
