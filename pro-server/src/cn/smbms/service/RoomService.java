package cn.smbms.service;

import cn.smbms.pojo.Room;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoomService {

    /**
     * 查询所有房型并分页
     */
    public PageInfo<Room> findAllRoomByPage(int page, int size);



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
}
