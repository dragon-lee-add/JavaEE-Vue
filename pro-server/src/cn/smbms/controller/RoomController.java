package cn.smbms.controller;

import cn.smbms.pojo.Room;
import cn.smbms.service.RoomService;
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
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;



    /*
    *前端接口
     */
    @RequestMapping(value="/findAllRoomVue",produces="application/json;charset=UTF-8")
    @ResponseBody
    public List<Room>  findAll(){
        List<Room> roomList = roomService.findAllRoomVue();
        System.out.println(roomList);
        return roomList;
    }
    /*
     *前端房型查询
     */
    @RequestMapping("/findRoomById")
    @ResponseBody
    public List<Room> findById(@RequestBody HashMap<String, String> map){
        List<Room> room = roomService.selectByIdOfVue(map.get("roomId"));
        System.out.println(room);
        return room;
    }



    /*
     * 房型查询所有
     */
    @RequestMapping(value = "/RoomList.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "5") int size, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        PageInfo<Room> pageInfo = roomService.findAllRoomByPage(page, size);
        //数据存储到分页插件
        mv.addObject("pageInfo", pageInfo);
        //视图跳转
        mv.setViewName("/Room/RoomManage");
        return mv;
    }

    //删除操作
    @RequestMapping("/delRoom.do")
    public String delRoom(Integer roomId) {
        roomService.deleteRoom(roomId);
        return "redirect:RoomList.do";
    }

    //修改操作
    @RequestMapping("/updRoomById.do")
    public String updRoomById(Room room, ModelMap model, Integer roomId) {
        roomService.updRoomById(room);
        return "redirect:RoomList.do";
    }


    //页面跳转
    @RequestMapping("/RoomUp.do")
    public String Page(String roomId, Model model) {
        Room room = roomService.selectById(roomId);
        model.addAttribute("room", room);
        return "/Room/RoomEdit";
    }

    /*
     * 新增
     */
    @RequestMapping(value = "/AddRoom.do", produces = "text/plain;charset=utf-8")
    public String insertRoom(HttpServletRequest request,
                             HttpServletResponse response, Model model) throws Exception {
        Room room = new Room();
        room.setPrice(request.getParameter("price"));
        room.setType(request.getParameter("type"));
        room.setArea(request.getParameter("area"));
        room.setTotal(request.getParameter("total"));
        room.setAddress(request.getParameter("address"));
        roomService.insertRoom(room);
        return "redirect:RoomList.do";
    }

}
