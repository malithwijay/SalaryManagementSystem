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
public class Employee {
    public String EID;
    public String EName;
    public String ESalary;
    public String EType;

    
    
    public Employee(String eid,String ename,String esalary,  String etype){
        
        this.EID=eid;
        this.EName=ename;
        this.ESalary=esalary;;
        this.EType=etype;
    }
 
    
}
