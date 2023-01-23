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
public class User {
    public String FirstName;
    public String LastName;
    public String UserNIC;
    public String UserName;
    public String UserPassword;
    public String Telephone;
    
    
    public User(String firstname,String lastname,String NIC, String username, String password, String telephone ){
        
        this.FirstName=firstname;
        this.LastName=lastname;
        this.UserNIC=NIC;
        this.UserName=username;
        this.UserPassword=password;
        this.Telephone=telephone;
    }
        
}
