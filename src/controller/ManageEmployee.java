/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.Dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Database;
import model.Employee;

/**
 *
 * @author malith
 */
public class ManageEmployee {
    Employee employee;
    
    public ManageEmployee(){}
    
    public ManageEmployee(Employee employee){
        this.employee=employee;
    }
    public void saveEmployee(){
        try{
            Connection con= Database.createConnection();
            
            String sql = "INSERT INTO employee (EmpID,EmpName,EmpSalary,EmpType) VALUES(?,?,?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1,employee.EID);
            stmt.setString(2,employee.EName);
            stmt.setString(3,employee.ESalary);
            stmt.setString(4,employee.EType);
  
            int rslt=stmt.executeUpdate();
            if(rslt>0){
            JOptionPane.showMessageDialog(null, "Empolyee Saved Sucessfully!","Save Employee",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "Empolyee Save Unsucessfull!","Save Employee",JOptionPane.INFORMATION_MESSAGE);
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
    
    public void UpdateEmployee(){
        try{
            Connection con= Database.createConnection();
            
            String sql = "UPDATE employee SET EmpName='"+employee.EName+"'"+", EmpSalary='"+employee.ESalary+"'"+",EmpType='"+employee.EType+"' "+" WHERE EmpID='"+employee.EID+"'";
            PreparedStatement stmt=con.prepareStatement(sql);
        
  
            int rslt=stmt.executeUpdate();
            if(rslt>0){
            JOptionPane.showMessageDialog(null, "Empolyee Updated Sucessfully!","Update Employee",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "Empolyee Update Unsucessfull!","Update Employee",JOptionPane.INFORMATION_MESSAGE);
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
    
    
    public void DeleteEmployee(){
        try{
            Connection con= Database.createConnection();
            
            String sql = "DELETE FROM employee WHERE EmpID='"+employee.EID+"'";
            PreparedStatement stmt=con.prepareStatement(sql);
        
  
            int rslt=stmt.executeUpdate();
            if(rslt>0){
            JOptionPane.showMessageDialog(null, "Empolyee Removed Sucessfully!","Remove Employee",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "Empolyee Remove Unsucessfull!","Remove Employee",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"DataBase Error!", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"DataBase Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    
}
