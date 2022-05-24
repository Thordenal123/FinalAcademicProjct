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

public class modelBeans {
    String username;
    String password;
    String role;
    String name;
    int price,stock;

    public modelBeans(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
  public modelBeans(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    public modelBeans(String username, String password){
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
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public static List<modelBeans> searchModelbean(Connection con, String query){
        List<modelBeans> res = new ArrayList<>();
        try{
            //Retrieves the data from database
            String qString = "SELECT * FROM acc WHERE USERNAME = ?";
            try (PreparedStatement ps = con.prepareStatement(qString)) {
                ps.setString(1, query);
                //Parses the ResultSet object and adds content to list as  object
                try (ResultSet records = ps.executeQuery()) {
                    //Parses the ResultSet object and adds content to list as object
                    while(records.next()){
                        res.add(new modelBeans(records.getString("username"), records.getString("password"), records.getString("role")));
                    }
                    ps.close();
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
     public static void insertModelbean(Connection con, String username, String password, String role){
        try{
            //Inserts the data into the database
            String qString = "INSERT INTO USERTABLE VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(qString); 
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

 public static List<modelBeans> viewmodelbean(Connection con){
        List<modelBeans> res = new ArrayList<>();
        try{
            //Retrieves the data from database
            String qString = "SELECT * FROM ITEMS";
            try (PreparedStatement ps = con.prepareStatement(qString)) {
                //Parses the ResultSet object and adds content to list as  object
                try (ResultSet records = ps.executeQuery()) {
                    //Parses the ResultSet object and adds content to list as object
                    while(records.next()){
                        res.add(new modelBeans(records.getString("name"), records.getInt("price"), records.getInt("stock")));
                    }
                    ps.close();
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
        }
public static List<modelBeans>searchbean(Connection con, String search){
        List<modelBeans> result = new ArrayList<>();
        try{
            
            String qString = "SELECT * FROM ITEMS WHERE ITEMNAME = ?";
            try (PreparedStatement ps = con.prepareStatement(qString)) {
                ps.setString(1, search);
               
                try (ResultSet records = ps.executeQuery()) {
                 
                    while(records.next()){
                        result.add(new modelBeans(records.getString("ITEMNAME"),records.getInt("price"), records.getInt("stock")));
                    }
                    ps.close();
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return result;
    }
       
   public static void deletebean(Connection con, String name){
       try{
          
         
          String query = "DELETE FROM ITEMS WHERE ITEMNAME=?";
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1,name);
          ps.executeUpdate();
          ps.close();
       }
       catch(SQLException e){
           System.out.println(e.getMessage());
       }
     }
     public static void addbean(Connection con, String name,int price, int stock){
        try{
           
            String query = "INSERT INTO ITEMS VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query); 
                ps.setString(1, name);
                ps.setInt(2, price);
                ps.setInt(3,stock);
                ps.executeUpdate();
                ps.close();
      
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
     }
}