/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import model.User;
import model.Database;





/**
 *
 * @author malith
 */
public class ManageUser {
    User user;
    
    public ManageUser(){}
    
    public ManageUser(User user){
        this.user=user;
    }
    
    public void saveUser(){
        try{
            Connection con= Database.createConnection();
            
            String sql = "INSERT INTO users(FirstName,LastName,NIC,UserName,Password,Telephone) VALUES(?,?,?,?,?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1,user.FirstName);
            stmt.setString(2,user.LastName);
            stmt.setString(3,user.UserNIC);
            stmt.setString(4,user.UserName);
            stmt.setString(5,user.UserPassword);
            stmt.setString(6,user.Telephone);
            
            int rslt=stmt.executeUpdate();
            if(rslt>0){
            JOptionPane.showMessageDialog(null, "User Registered Sucessfully!","Save User",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "User Registeration Unsucessfull!","Save User",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"DataBase Error!", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
        
}
