package cn.nfj.mservice.util;



import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 读取配置文件
 * @author liubin
 */
public class PropertiesConfig {

    public static Map<String, String> propertiesMap = new HashMap<>();

    public static void processProperties(Properties props) throws Exception {
        propertiesMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            try {
                propertiesMap.put(keyStr, new String(props.getProperty(keyStr).getBytes("ISO-8859-1"), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties");
            processProperties(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void loadAllProperties(String propertyFileName) {
        try {
            Properties properties;
            properties = PropertiesLoaderUtils.loadAllProperties(propertyFileName);
            processProperties(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String name) {
        return propertiesMap.get(name).toString();
    }

    public static Map<String, String> getAllProperty() {
        return propertiesMap;
    }


}
