/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Goldworth
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountModel {
    String username;
    String password;
    String role;
//java bean     
    public AccountModel(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public AccountModel(String username, String password){
        this.username = username;
        this.password = password;
    }
    
     public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getRole(){
        return role;
    }
    
    //Models for both login and signup
    public static List<AccountModel> loginModel(Connection conn, String query){
        List<AccountModel> res = new ArrayList<>();
        try{
            
            String qString = "SELECT *  FROM USERTABLE WHERE USERNAME = ?";
            try (PreparedStatement ps = conn.prepareStatement(qString)) {
                ps.setString(1, query);
                
                try (ResultSet rec = ps.executeQuery()) {
                    
                    while(rec.next()){
                        res.add(new AccountModel(rec.getString("username"), rec.getString("password"), rec.getString("role")));
                    }
                    ps.close();
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
     public static void signupModel(Connection conn, String username, String password, String role)
     {
         
        try
        {
            String qString = "INSERT INTO USERTABLE VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(qString); 
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);                
                ps.executeUpdate();
                ps.close();
      
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
     }
     
}
