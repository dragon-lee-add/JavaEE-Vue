package cn.smbms.service;

import cn.smbms.dao.ClientDao;
import cn.smbms.pojo.Client;
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
    public PageInfo<Client> findAllClientByPage() {
        List<Client> list = clientDao.selectAllClient();

        return new PageInfo<Client>(list);
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
