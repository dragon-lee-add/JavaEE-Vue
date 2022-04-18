package cn.smbms.pojo;

public class Room {
    private Integer roomId;
    private String price;
    private String type;
    private String area;
    private String address;
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", total=" + total +
                '}';
    }
}
