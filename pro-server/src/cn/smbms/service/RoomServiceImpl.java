package cn.smbms.service;

import cn.smbms.dao.RoomDao;
import cn.smbms.pojo.Room;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public PageInfo<Room> findAllRoomByPage() {

        List<Room> list = roomDao.selectAllRoom();

        //PageInfo<Room> pageInfo=new PageInfo<Room>(list);
//        System.out.println("获取当前页："+pageInfo.getPageNum());
//        System.out.println("获取总页数："+pageInfo.getPages());
//        System.out.println("每页条数："+pageInfo.getPageSize());
//        System.out.println("总记录数："+pageInfo.getTotal());
//        System.out.println("当前页数据："+pageInfo.getList().size());

        return new PageInfo<Room>(list);
    }

    @Override
    public Integer deleteRoom(Integer roomId) {
        return roomDao.deleteRoom(roomId);
    }

    @Override
    public void updRoomById(Room room) {

        roomDao.updRoomById(room);
    }

    @Override
    public List<Room> selectByIdOfVue(String roomId) {
        System.out.println(roomId);
        return roomDao.selectByIdOfVue(roomId);
    }

    @Override
    public Room selectById(String roomId) {
        return roomDao.selectById(roomId);
    }

    @Override
    public Integer insertRoom(Room room) {
        return roomDao.insertRoom(room);
    }

    @Override
    public List<Room> findAllRoomVue() {
        System.out.println("测试");
        return roomDao.findAllRoomVue();
    }


}
