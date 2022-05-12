package cn.smbms.interceptor;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelFet {
    public List readExcel(File file) {
        try {
            InputStream is = new FileInputStream(file.getAbsolutePath()); // 创建输入流，读取Excel
            Workbook wb = Workbook.getWorkbook(is);// jxl提供的Workbook类
            int sheet_size = wb.getNumberOfSheets(); // Excel的页签数量
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList=new ArrayList<List>();
                Sheet sheet = wb.getSheet(index); // 每个页签创建一个Sheet对象
                for (int i = 0; i < sheet.getRows(); i++) {// sheet.getRows()返回该页的总行数
                    List innerList=new ArrayList();
                    for (int j = 0; j < sheet.getColumns(); j++) {// sheet.getColumns()返回该页的总列数
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                        System.out.print(cellinfo);
                    }
                    outerList.add(i, innerList);
                    System.out.println();
                }
                is.close();
                return outerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
