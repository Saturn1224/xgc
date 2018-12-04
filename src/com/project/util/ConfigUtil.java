package com.project.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2018/11/8 0008.
 */
public class ConfigUtil {
    public  static   Properties  pros = null;
          static {
            pros=new Properties();
            InputStream is = ConfigUtil.class.getClassLoader().getResourceAsStream("my.properties");
            try {
                pros.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public static  String getValue(String key){
        return  pros.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(ConfigUtil.getValue("mysql.url"));
    }
}
