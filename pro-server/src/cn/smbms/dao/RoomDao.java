package cn.smbms.dao;

import cn.smbms.pojo.Room;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RoomDao {
    /*
     * 查询所有切分页
     */
    public List<Room> selectAllRoom();


    /*
     * 删除
     */
    public Integer deleteRoom(Integer roomId);

    /**
     * 修改房型
     */
    public Integer updRoomById(Room room);

    /**
     * 前端
     */
    List<Room> selectByIdOfVue(@RequestBody String roomId);

    Room selectById(String roomId);
    /**
     * 新增
     */
    public Integer insertRoom(Room room);


    /*
     *前端接口
     */
    List<Room> findAllRoomVue();
    List<Room> findRoomVue1(@RequestBody Integer categoryId);
    List<Room> findRoomVue2(@RequestBody Integer categoryId);
    List<Room> findRoomVue3(@RequestBody Integer categoryId);
    List<Room> findRoomVue4(@RequestBody Integer categoryId);
    List<Room> findRoomVue5(@RequestBody Integer categoryId);



}


