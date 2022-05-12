package cn.smbms.controller;

import cn.smbms.interceptor.ExcelFet;
import cn.smbms.interceptor.ExcelUpload;
import cn.smbms.pojo.Client;
import cn.smbms.service.ClientService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

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
    public ModelAndView findAll(@RequestParam(required = false,defaultValue = "1",value = "page")Integer page,
                              HttpSession session) {
        ModelAndView mv = new ModelAndView();
        PageHelper.startPage(page,10);
        //分页查询
        PageInfo<Client> pageInfo = clientService.findAllClientByPage();
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

    /**
     * excel导出
     */
    @RequestMapping("downExcel")
    public void downExcel(HttpServletResponse response,HttpServletRequest request,Model model,
                           String name,Integer roomId) throws UnsupportedEncodingException {
        //获取列表用户信息
        PageInfo<Client> pageInfo = clientService.findAllClientByPage();

        Collection<Client> list=new ArrayList<Client>();
        Client client=new Client();
        //遍历数组
        List<Client> tempClient=pageInfo.getList();
        for (Client client1:tempClient){
            name=client1.getName();
            roomId=client1.getRoomId();
        }
        //添加到excel
        client.setRoomId(Integer.valueOf(roomId));
        client.setName(name);
        list.add(client);
        ExportParams params=new ExportParams();
        Workbook workbook= ExcelExportUtil.exportExcel(params,Client.class,list);
        response.setHeader("content-Type", "application/vnd.ms-excel");
        String title="客户信息";//设置导出的文件名
        response.setHeader("Content-DisPosition", "attachment;filename="+ URLEncoder.encode(title, "UTF-8")+".xls");
        response.setCharacterEncoding("UTF-8");
        try {
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * excel导入
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importExcel(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request,ModelMap model) {

        ExcelUpload excelUpload = new ExcelUpload();
        File f = excelUpload.importExcel(file, request);
        ExcelFet excelUtil = new ExcelFet();
        List list = excelUtil.readExcel(f);
        if(f.exists()){
            System.out.println("导入成功");
            model.addAttribute("msg", "导入成功！");
        }
        return "redirect:ExcelImport";
    }



}
