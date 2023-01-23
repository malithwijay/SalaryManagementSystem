/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author malith
 */
public class EmployeeType {
    public String TypeID;
    public String TypeName;
    public String TypeSalary;

    
    public EmployeeType(String typeid,String typename,String typesalary){
        
        this.TypeID=typeid;
        this.TypeName=typename; 
        this.TypeSalary=typesalary;
    }
}
