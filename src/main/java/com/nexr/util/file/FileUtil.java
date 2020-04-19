package com.nexr.util.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Create by lucy on 2020-04-17
 **/
public class FileUtil {
    private static final String UTF_8 = "UTF-8";

    /* 파일 인코딩 형식에 따라 Read
     *
     */
    public static BufferedReader readFile(String filePath) throws Exception {
        return new BufferedReader(new InputStreamReader(new FileInputStream(filePath), UTF_8));
    }

}
