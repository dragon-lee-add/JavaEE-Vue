package cn.smbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {


    @RequestMapping(value = "/")
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response, Model model) throws Exception {
        return "Login";
    }

    @RequestMapping(value = "/Index")
    public String handleRequestIndex(HttpServletRequest request,
                                     HttpServletResponse response, Model model) throws Exception {
        return "Index";
    }

    @RequestMapping(value = "/Message")
    public String handleRequestMessage(HttpServletRequest request,
                                       HttpServletResponse response, Model model) throws Exception {
        return "Message";
    }


    @RequestMapping(value = "/EditPwd")
    public String handleRequestEditPwd(HttpServletRequest request,
                                       HttpServletResponse response, Model model) throws Exception {
        return "EditPwd";
    }

    @RequestMapping(value = "/FileUpload")
    public String handleRequestFileUpload(HttpServletRequest request,
                                       HttpServletResponse response, Model model) throws Exception {
        return "FileUpload";
    }
    @RequestMapping(value = "/ExcelImport")
    public String handleRequestExcelImport(HttpServletRequest request,
                                          HttpServletResponse response, Model model) throws Exception {
        return "ExcelImport";
    }
    /**
     * 房型管理界面
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/RoomManage")
    public String handleRequestRoomManage(HttpServletRequest request,
                                          HttpServletResponse response, Model model) throws Exception {
        return "RoomManage";
    }

    @RequestMapping(value = "/RoomEdit")
    public String handleRequestRoomEdit(HttpServletRequest request,
                                        HttpServletResponse response, Model model) throws Exception {
        return "RoomEdit";
    }

    @RequestMapping(value = "/RoomAdd")
    public String handleRequestRoomAdd(HttpServletRequest request,
                                        HttpServletResponse response, Model model) throws Exception {
        return "/Room/RoomAdd";
    }


    /**
     * 客户管理界面dit
     */
    @RequestMapping(value = "/ClientManage")
    public String handleRequestClientManage(HttpServletRequest request,
                                          HttpServletResponse response, Model model) throws Exception {
        return "ClientManage";
    }

    @RequestMapping(value = "/ClientEdit")
    public String handleRequestClientEdit(HttpServletRequest request,
                                        HttpServletResponse response, Model model) throws Exception {
        return "ClientEdit";
    }

    @RequestMapping(value = "/ClientAdd")
    public String handleRequestClientAdd(HttpServletRequest request,
                                       HttpServletResponse response, Model model) throws Exception {
        return "/Client/ClientAdd";
    }


}
