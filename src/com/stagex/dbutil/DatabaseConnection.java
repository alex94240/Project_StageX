package com.stagex.dbutil;

import java.sql.*; 

public class DatabaseConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/stagex?useSSL=false";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "root";
    private Connection conn = null;
 
    public DatabaseConnection() throws Exception {
       Class.forName(DBDRIVER);
       this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
       System.out.println("Connect succ");
    }
 
    public Connection getConnection() {
       return this.conn;
    }
 
    public void close() throws Exception {
       if (this.conn != null) {
           try {
              this.conn.close();
           } catch (Exception e) {
              throw e;
           }
       }
    }

}
