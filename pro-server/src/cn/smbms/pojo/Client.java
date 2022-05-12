package cn.smbms.pojo;

import org.jeecgframework.poi.excel.annotation.Excel;

public class Client {
    private Integer id;
    @Excel(name="购买房型号",height=5,width=10)
    private Integer roomId;
    @Excel(name="姓名",height=5,width=10)
    private String name;
    private String sex;
    private String phone;
    private String age;
    private String addr;
    private String userId;
    private String passWord;
    private Room room;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", userId=" + userId +
                ", passWord='" + passWord + '\'' +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                ", age='" + age + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
