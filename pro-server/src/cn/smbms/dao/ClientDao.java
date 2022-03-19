package cn.smbms.dao;

import cn.smbms.pojo.Client;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClientDao {
    /*
     * 查询所有切分页
     */
    public List<Client> selectAllClient();


    Client selectById(Integer id);
    /**
     * 修改客户信息
     */
    public Integer updClientById(Client client);

    /**
     * 新增
     */
    public Integer insertClient(Client client);

    /*
     *管理员登录
     */
    public Client LoginClient(@RequestBody Client client);

    /*
     *前端注册
     */
    public Integer RegisterClient(@RequestBody Client client);
}
