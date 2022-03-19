package cn.smbms.controller;

import cn.smbms.pojo.Client;
import cn.smbms.service.ClientService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;


    /**
     * 用户登录
     */
    @RequestMapping(value = "/loginClient")
    @ResponseBody
    public Map<String,Object> login( @RequestBody Client client) {
        Map<String, Object> map = new HashMap<String, Object>();
        Client client2 = clientService.LoginClient(client);
        System.out.println(client2);
        if(client2!=null) {
            map.put("code",200);
        }else {
            map.put("code","用户名或密码错误！");
        }
        return map;
    }
    @RequestMapping(value = "/registerClient")
    @ResponseBody
    public Map<String,Object> register( @RequestBody Client client) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer client2 = clientService.RegisterClient(client);
        System.out.println(client2);
        if(client2!=null) {
            map.put("code",200);
        }else {
            map.put("code","注册失败！");
        }
        return map;
    }

    /*
     * 客户查询所有
     */
    @RequestMapping(value = "/ClientList.do")
    public ModelAndView findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "4") Integer size,
                              HttpSession session) {
        ModelAndView mv = new ModelAndView();
        //分页查询
        PageInfo<Client> pageInfo = clientService.findAllClientByPage(page,size);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("/Client/ClientManage");
        return mv;
    }


    //页面跳转
    @RequestMapping("/ClientUp.do")
    public String Page( Model model,Integer id) {
        Client client = clientService.selectById(id);
        model.addAttribute("client", client);
        return "/Client/ClientEdit";
    }

    //修改操作
    @RequestMapping("/upClientById.do")
    public String updRoomById(Client client, ModelMap model, Integer roomId) {
        clientService.updClientById(client);
        return "redirect:ClientList.do";
    }

    /*
     * 新增
     */
    @RequestMapping(value = "/AddClient.do", produces = "text/plain;charset=utf-8")
    public String insertClient(HttpServletRequest request,
                             HttpServletResponse response, Model model) throws Exception {
        Client client = new Client();
       client.setRoomId(Integer.valueOf(request.getParameter("roomId")));
       client.setName(request.getParameter("name"));
       client.setSex(request.getParameter("sex"));
       client.setAge(request.getParameter("age"));
       client.setAddr(request.getParameter("addr"));
       client.setPhone(request.getParameter("phone"));
       clientService.insertClient(client);
        return "redirect:ClientList.do";
    }

}
