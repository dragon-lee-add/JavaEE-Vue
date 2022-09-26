package cn.smbms.service;

import cn.smbms.dao.InformationsDao;
import cn.smbms.pojo.Informations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InformationsServiceImpl implements InformationsService{

    @Autowired
    InformationsDao informationsDao;

    @Override
    public List<Informations> findInformations() {

        return informationsDao.findInformations();
    }


}
