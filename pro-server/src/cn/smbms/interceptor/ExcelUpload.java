package cn.smbms.interceptor;

import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class ExcelUpload {
    public File importExcel(MultipartFile file, HttpServletRequest request) {
        try {
            ImportParams params = new ImportParams();
            params.setTitleRows(1);
            params.setHeadRows(2);
            params.setNeedSave(true);
            String path = request.getSession().getServletContext().getRealPath("");
            File f = new File(path+"/excel/"+file.getOriginalFilename());
            if(!f.exists()){
                try {
                    File dir = new File(path+"/excel/");
                    dir.mkdirs();
                    if(f.createNewFile()){
                        System.out.println("创建文件成功");
                    }else{
                        System.out.println("创建文件失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            file.transferTo(f);
            return f;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
