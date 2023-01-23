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
import model.Salary;
import model.Database;





/**
 *
 * @author malith
 */
public class ManageSalary {
    Salary salary;
    
    public ManageSalary(){}
    
    public ManageSalary(Salary salary){
        this.salary=salary;
    }
    public void saveSalary(){
        try{
            Connection con= Database.createConnection();
            
            String sql = "INSERT INTO empsalary(SalID,EmpID,EmpName,EmpType,SalTotal,Allowance,date) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
           
                   java.util.Date utilDate = new java.util.Date();
                   java.sql.Timestamp date = new java.sql.Timestamp(utilDate.getTime());
            
            stmt.setString(1,salary.SalID);
            stmt.setString(2,salary.EmpID);
            stmt.setString(3,salary.EmpName);
            stmt.setString(4,salary.EmpType);
            stmt.setString(5,salary.Salary);
            stmt.setString(6,salary.Allowance);
            stmt.setTimestamp(7,date);

            int rslt=stmt.executeUpdate();
            if(rslt>0){
            JOptionPane.showMessageDialog(null, "Salary Saved Sucessfully!","Save Salary",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "Salary Save Unsucessfull!","Save Salary",JOptionPane.INFORMATION_MESSAGE);
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
