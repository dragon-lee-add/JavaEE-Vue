package cn.smbms.pojo;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Room {
    private Integer roomId;
    private String price;
    private String type;
    private String area;
    private String address;
    private String total;
    private String roomDescribe;
    private Integer categoryId;
    private  Category category;
}
