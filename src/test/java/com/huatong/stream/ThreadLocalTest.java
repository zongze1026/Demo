package com.huatong.stream;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Create By xzz on 2018/1
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread thread = new Thread(){
            @Override
            public void run() {
                threadLocal.set("test");
            }
        };
        thread.start();




    }

//    public static void connect(){
//        String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
//        String USER="root";
//        String PASSWORD="tiger";
//        //1.加载驱动程序
//        Class.forName("com.mysql.jdbc.Driver");
//        //2.获得数据库链接
//        Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
//        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
//        Statement st=conn.createStatement();
//        ResultSet rs=st.executeQuery("select * from user");
//        //4.处理数据库的返回结果(使用ResultSet类)
//        while(rs.next()){ System.out.println(rs.getString("user_name")+" 26+rs.getString("user_password")); }
//
//                //关闭资源
//                rs.close();
//            st.close();
//            conn.close();
//    }



}
