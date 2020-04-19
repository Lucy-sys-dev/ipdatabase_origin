package com.nexr.util.file;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Create by lucy on 2020-04-17
 **/
public class PoiUtil {
    public static Workbook getWorkbook(String filePath){
        try {
            return WorkbookFactory.create(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
