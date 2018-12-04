package com.project.dao.imp;



import com.project.util.ConfigUtil;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.logging.LogFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 2018/11/8 0008.
 */
public class BaseDaoImpl {
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs =null;

    public Connection  getCon(){

        //step1：加载驱动

        try {
            Class.forName(ConfigUtil.getValue("mysql.driver"));
            //step2 获取数据库连接
            conn = DriverManager.getConnection(ConfigUtil.getValue("mysql.url"),
                   ConfigUtil.getValue("mysql.user"),
                   ConfigUtil.getValue("mysql.password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;
    }


    public void close(Connection  conn, PreparedStatement ps, ResultSet rs){
        try {
            if(conn!=null)conn.close();
            if(ps!=null)ps.close();
            if(rs!=null)rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  int  excupdate(final String sql,final Object[] objects){
        int i =0;
         conn = this.getCon();
        try {
             ps = conn.prepareStatement(sql);
             for(int j=0;j<objects.length;j++){
                 ps.setObject(j+1,objects[j]);
             }
             i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

      return  i;
    }

    public ResultSet  execQuery(final  String sql,final Object[] objects){
        this.getCon();
        try {
            ps =  conn.prepareStatement(sql);
            for(int i=0;i<objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }


/*
* jndi 获取数据库连接
* */
    public Connection getConn1() {
        Connection conn = null;

        try {
            // Obtain our environment naming context
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

// Look up our data source
            DataSource ds = (DataSource)
                    envCtx.lookup("jdbc/EmployeeDB");
            // Allocate and use a connection from the pool
            conn = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public Connection getConn2(){
        Connection connection=null;
        Properties pro = new Properties();
        InputStream is = BaseDaoImpl.class.getClassLoader().getResourceAsStream("DBCP.properties");
        try {
            pro.load(is);
            //获取Connetion连接
            DataSource dataSource = BasicDataSourceFactory.createDataSource(pro);
          conn= dataSource.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }




    public static void main(String[] args) {
        System.out.println(new BaseDaoImpl().getConn2());
    }
}
