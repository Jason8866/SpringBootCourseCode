package com.example.mail.utils;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;

/**
 * @Author Zhicheng
 * @Description TODO
 * @Date 2020/6/13 12:02
 * @Version 1.0
 **/
public class BaseUtils {

    /**
     * 保存输入流到文件
     *
     * @param path
     * @param inputStream
     * @throws IOException
     */
    public static void saveStreamToFile(String path, InputStream inputStream) throws IOException {
        File saveFile = new File(path);
        File dir = saveFile.getParentFile();
        if (dir != null) {
            if (!dir.exists()) {
                FileUtils.forceMkdir(dir);
            }
        }
        OutputStream output = new FileOutputStream(saveFile);
        IOUtils.copy(inputStream, output);
        output.flush();
        output.close();
        inputStream.close();
    }

    /**
     * 保存输入流到文件
     *
     * @param path
     * @param inputStream
     * @throws IOException
     */
    public static File saveAndgetFile(String path, InputStream inputStream) throws IOException {
        File saveFile = new File(path);
        File dir = saveFile.getParentFile();
        if (dir != null) {
            if (!dir.exists()) {
                FileUtils.forceMkdir(dir);
            }
        }
        OutputStream output = new FileOutputStream(saveFile);
        IOUtils.copy(inputStream, output);
        output.flush();
        output.close();
        inputStream.close();

        return saveFile;
    }

}
