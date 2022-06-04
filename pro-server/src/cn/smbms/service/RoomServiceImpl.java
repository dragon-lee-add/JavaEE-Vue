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

        return roomDao.findAllRoomVue();
    }

    @Override
    public List<Room> findRoomVue1(Integer categoryId) {
        return roomDao.findRoomVue1(categoryId);
    }

    @Override
    public List<Room> findRoomVue2(Integer categoryId) {
        return  roomDao.findRoomVue2(categoryId);
    }

    @Override
    public List<Room> findRoomVue3(Integer categoryId) {
        return  roomDao.findRoomVue3(categoryId);
    }

    @Override
    public List<Room> findRoomVue4(Integer categoryId) {
        return  roomDao.findRoomVue4(categoryId);
    }

    @Override
    public List<Room> findRoomVue5(Integer categoryId) {
        return  roomDao.findRoomVue5(categoryId);
    }


}
