/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author malith
 */
public class Database {
    public static Connection createConnection() throws Exception{
        String url="jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false";
        Connection con=DriverManager.getConnection(url,"root","");
        return con;
    }
}
