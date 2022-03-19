package cn.smbms.service;

import cn.smbms.dao.ClientDao;
import cn.smbms.pojo.Client;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientDao clientDao;

    @Override
    public PageInfo<Client> findAllClientByPage(int page, int size) {
        PageHelper.startPage(page,size);
        List<Client> list = clientDao.selectAllClient();
        System.out.println(list);
        PageInfo<Client> pageInfo=new PageInfo<Client>(list);
        System.out.println("获取当前页："+pageInfo.getPageNum());
        System.out.println("获取总页数："+pageInfo.getPages());
        System.out.println("每页条数："+pageInfo.getPageSize());
        System.out.println("总记录数："+pageInfo.getTotal());
        System.out.println("当前页数据："+pageInfo.getList().size());
        return pageInfo;
    }

    @Override
    public Client selectById(Integer id) {
        return clientDao.selectById(id);
    }

    @Override
    public void updClientById(Client client) {
        clientDao.updClientById(client);
    }

    @Override
    public Integer insertClient(Client client) {
        return clientDao.insertClient(client);
    }

    @Override
    public Client LoginClient(Client client) {
        System.out.println("用户"+client);
        return  clientDao.LoginClient(client);

    }

    @Override
    public Integer RegisterClient(Client client) {
        System.out.println("注册用户"+client);
        return clientDao.RegisterClient(client);
    }
}
