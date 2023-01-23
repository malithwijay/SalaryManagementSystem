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
import model.EmployeeType;
import model.Database;

/**
 *
 * @author malith
 */
public class ManageEmployeeType {
    EmployeeType employeetype;
    
    public ManageEmployeeType(){}
    
    public ManageEmployeeType(EmployeeType employeetype){
        this.employeetype=employeetype;
    }
    
    public void saveEmployeeType(){
        try{
            Connection con= Database.createConnection();
            
            String sql = "INSERT INTO emptype(EmpTypeID,EmpTypeName,EmpTypeSalary) VALUES(?,?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1,employeetype.TypeID);
            stmt.setString(2,employeetype.TypeName);
            stmt.setString(3,employeetype.TypeSalary);

            int rslt= stmt.executeUpdate();
            
            if(rslt>0){
            JOptionPane.showMessageDialog(null, "Empolyee Type Saved Sucessfully!","Save Empolyee Type",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "Empolyee Type Unsucessfull!","Save Empolyee Type",JOptionPane.INFORMATION_MESSAGE);
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
    
    public void UpdateEmployeeType(){
        try{
            Connection con= Database.createConnection();
            
            String sql = "UPDATE emptype SET EmpTypeName='"+employeetype.TypeName+"'"+",EmpTypeSalary='"+employeetype.TypeSalary+"'"+" WHERE EmpTypeID='"+employeetype.TypeID+"'";
            PreparedStatement stmt=con.prepareStatement(sql);
        
  
            int rslt= stmt.executeUpdate();
            
            if(rslt>0){
            JOptionPane.showMessageDialog(null, "Empolyee Type Updated Sucessfully!","Update Empolyee Type",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "Empolyee Type Update Unsucessfull!","Update Empolyee Type",JOptionPane.INFORMATION_MESSAGE);
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
    
    
    public void DeleteEmployeeType(){
        try{
            Connection con= Database.createConnection();
            
            String sql = "DELETE FROM emptype WHERE EmpTypeID='"+employeetype.TypeID+"'";
            PreparedStatement stmt=con.prepareStatement(sql);
        
  
            int rslt= stmt.executeUpdate();
            
            if(rslt>0){
            JOptionPane.showMessageDialog(null, "Empolyee Type Removed Sucessfully!","Remove Empolyee Type",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(null, "Empolyee Type Remove Unsucessfull!","Remove Empolyee Type",JOptionPane.INFORMATION_MESSAGE);
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
