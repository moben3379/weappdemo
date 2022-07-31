package cn.edu.guet.weappdemo.wxpay.utils;

import java.io.*;
import java.net.URLDecoder;

/**
 * File工具类，扩展 hutool 工具包
 */
public class FileUtil {
    /**
     * {@code description: 获取资源文件绝对路径,文件在项目下}
     */
    public static String getResourcesPath() {
        String classFilePath = FileUtil.class.getResource("/").getPath();
        try {
            classFilePath = URLDecoder.decode(classFilePath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return classFilePath;
    }

}
