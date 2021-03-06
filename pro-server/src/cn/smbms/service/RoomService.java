package cn.smbms.service;

import cn.smbms.pojo.Room;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoomService {

    /**
     * 查询所有房型并分页
     */
    public PageInfo<Room> findAllRoomByPage();



    /*
     * 删除
     */
    public Integer deleteRoom(Integer roomId);

    /**
     * 修改房型
     */
    public void updRoomById(Room room);

    /**
     * 通过id查询
     * @param roomId
     * @return
     */
    List<Room> selectByIdOfVue(String roomId);
    Room selectById(String roomId);

    /**
     * 新增
     */
    public Integer insertRoom(Room room);

    /*
     *vue查询，前端接口
     */
    List<Room> findAllRoomVue();
    List<Room> findRoomVue1(Integer categoryId);
    List<Room> findRoomVue2( Integer categoryId);
    List<Room> findRoomVue3(Integer categoryId);
    List<Room> findRoomVue4(Integer categoryId);
    List<Room> findRoomVue5(Integer categoryId);
}
