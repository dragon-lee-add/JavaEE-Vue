package cn.smbms.pojo;

import lombok.Data;
import lombok.ToString;
import org.jeecgframework.poi.excel.annotation.Excel;

@Data
@ToString
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


}
