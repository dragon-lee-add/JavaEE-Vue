package cn.smbms.service;

import cn.smbms.pojo.Client;
import com.github.pagehelper.PageInfo;

public interface ClientService {

    /**
     * 查询所有客户并分页
     */
    public PageInfo<Client> findAllClientByPage(int page, int size);


    Client selectById(Integer id);


    /**
     * 修改客户
     */
    public void updClientById(Client client);


    /**
     * 新增
     */
    public Integer insertClient(Client client);

    /**
     * 登录
     * @return
     */
    public Client LoginClient(Client client);

    /**
     * 注册
     * @return
     */
    public Integer RegisterClient(Client client);

}
