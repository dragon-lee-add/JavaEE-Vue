package cn.smbms.controller;

import cn.smbms.pojo.Informations;
import cn.smbms.service.InformationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InformationsController {

    @Autowired
    private InformationsService informationsService;

    @RequestMapping(value="/findInformations.do", method = RequestMethod.POST)
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Informations> informationsList = informationsService.findInformations();
        //数据存储到
        System.out.println(informationsList);
        mv.addObject("informationsList", informationsList);
        //视图跳转
        mv.setViewName("/Test");
        return mv;
    }

}
