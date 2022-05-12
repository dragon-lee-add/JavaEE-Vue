package cn.smbms.controller;

import cn.smbms.pojo.MyFile;
import cn.smbms.service.MyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FileUploadController {

    @Autowired
    private MyFileService myFileService;

    @RequestMapping("/insertFile.do")
    public String insertFile(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        //String filePath = "F:\\JavaEE-Vue\\pro-server\\web\\ueditor\\jsp\\upload";//保存图片的路径,tomcat中有配置
        MyFile myFile=new MyFile();
        myFile.setFileTitle(request.getParameter("fileTitle"));
        myFile.setFileUrl(request.getServletContext().getRealPath("/upload"));
        myFileService.insertFile(myFile);
        return "redirect:/FileUpload";
    }
}