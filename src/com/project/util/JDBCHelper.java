package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Administrator on 2018/11/19 0019.
 */
public class JDBCHelper {
    private  static JDBCHelper instance=null;
    private LinkedList<Connection> datasource=null;

    private  JDBCHelper(){
        datasource= new LinkedList<>();
        for(int i=0;i<10;i++){
            try {
                Class.forName(ConfigUtil.getValue("mysql.driver"));
                //step2 获取数据库连接
                Connection conn = DriverManager.getConnection(ConfigUtil.getValue("mysql.url"),
                        ConfigUtil.getValue("mysql.user"),
                        ConfigUtil.getValue("mysql.password"));
                datasource.add(conn);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static JDBCHelper getInstance(){
        if(instance==null){
            synchronized (JDBCHelper.class){
                if(instance==null){
                    instance=new JDBCHelper();
                }

            }

        }
        return  instance ;
    }

    public Connection getCon(){
        if(datasource.size()>0){
            return  datasource.poll();
        }else {
            while(datasource.size()==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return  datasource.poll();
        }
    }
    public void close(Connection  conn){
        datasource.push(conn);

    }


}
