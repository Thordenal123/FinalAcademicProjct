/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Thomas Jefferson Qiu
 */

public class LoginCheck extends HttpServlet {
    Statement ps = null;
    ResultSet resultSet = null;
    String userrole = "";
    String username;
    String password;
    String role;
    
public LoginCheck(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
     
    public String authenticateUser(Connection conn, String role){
        try{
            
            String qString = "SELECT *  FROM USERTABLE WHERE ROLE = admin";
           Statement ps = conn.createStatement();
           resultSet = ps.executeQuery(qString);
            {
               while(resultSet.next()) 
               {    
                    if(role.equals("admin")){
                        
                    }
                    ps.close();
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return  "admin";
                
    }
}