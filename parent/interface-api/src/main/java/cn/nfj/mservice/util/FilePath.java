package cn.nfj.mservice.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: Administrator
 * @Date: 2018/7/3 11:04
 * @Description:
 */
public class FilePath {

    private static final String basePath = FilePath.class.getClassLoader().getResource("").getPath();

    public static String uploadImgPath(){
        return basePath + PropertiesConfig.getProperty("uploadImg");
    }
}
