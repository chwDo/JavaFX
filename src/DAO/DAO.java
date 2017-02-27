/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author acer
 */
public class DAO {
    private Connection conn;
    private Statement stmt;
    public DAO() {
        conn=null;
        stmt=null;
        String url="jdbc:mysql://localhost:3306/exam?user=root&password=123456&Unicode=true&characterEncoding=UTF-8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url);

        } catch (Exception e) {
            System.out.println("get DBconnection failed");
        }
    }
    public Statement getstatement() throws SQLException{
        stmt=conn.createStatement();
        return stmt;
    }
    public void close() throws SQLException{
        stmt.close();
        conn.close();
    }
    public Connection getConnection(){
        return conn;
    }
}
