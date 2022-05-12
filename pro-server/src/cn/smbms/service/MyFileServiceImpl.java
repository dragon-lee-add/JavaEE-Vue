package cn.smbms.service;

import cn.smbms.dao.MyFileDao;
import cn.smbms.pojo.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyFileServiceImpl implements MyFileService {

    @Autowired
    private MyFileDao myFileDao;


    @Override
    public int insertFile(MyFile myFile) {
        myFileDao.insertFile(myFile);
        return 0;
    }
}
