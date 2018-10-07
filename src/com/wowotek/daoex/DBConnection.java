package com.wowotek.daoex;

import java.sql.*;

public class DBConnection {
    private final String db_host = "jdbc:mysql://localhost:3306/Random?user=wowotek&password=password";
    
    public Connection con;
    private static DBConnection db = null;
    
    private DBConnection(){
        try {
            this.con = DriverManager.getConnection(db_host);
            System.err.println("Connection Established");
        } catch (SQLException ex) {
            System.err.println("Connection Failed\n"+ex.getMessage());
        }
    }
    
    public static DBConnection getInstance(){
        if(db == null){
            db = new DBConnection();
        }
        
        return db;
    }
}
