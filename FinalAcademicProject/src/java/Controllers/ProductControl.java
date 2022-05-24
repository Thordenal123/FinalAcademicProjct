/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas Jefferson Qiu
 */
public class ProductControl extends HttpServlet {

Connection conn;
    @Override
    public void init(ServletConfig config) throws ServletException{
       super.init(config);
       
        //Establish a Connection to the Database
        try {
            Class.forName(config.getInitParameter("jdbcClassName"));
            System.out.println("jdbcClassName: " + config.getInitParameter("jdbcClassName"));
            String username = config.getInitParameter("dbUserName");
            String password = config.getInitParameter("dbPassword");
            StringBuffer url = new StringBuffer(config.getInitParameter("jdbcDriverURL"))
                    .append("://")
                    .append(config.getInitParameter("dbHostName"))
                    .append(":")
                    .append(config.getInitParameter("dbPort"))
                    .append("/")
                    .append(config.getInitParameter("databaseName"));
            conn = DriverManager.getConnection(url.toString(), username, password);
            
            
        } catch (SQLException sqle) {
            System.out.println("SQLException error occured - "
                    + sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(request.getParameter("Search") != null){
                String hanapName = request.getParameter("name");
                if (conn != null) {
                    List<modelBeans> Product = modelBeans.searchbean(conn, hanapName);
                    if(Product.isEmpty()){
                    response.sendRedirect("error.jsp");
                    return;
                    }
                    request.setAttribute("result", Product);
                
                } else {
                    response.sendRedirect("error.jsp"); 
                }
                    request.getRequestDispatcher("result.jsp").forward(request, response);
            
                    }

             else if(request.getParameter("view") != null){
               List<modelBeans> Product = modelBeans.viewmodelbean(conn);
                
                if (conn != null) {
                                      
                    request.setAttribute("result", Product);
                
                } else {
                    response.sendRedirect("error.jsp"); 
                }
                    request.getRequestDispatcher("result.jsp").forward(request, response);
            
                    }

           else if(request.getParameter("delete")!= null){
                
                if(conn != null){
                String name = request.getParameter("ProdDel");
                List<modelBeans> delete= modelBeans.searchbean(conn, name);
                if(delete.isEmpty()){
                    response.sendRedirect("error.jsp");
                    return;
                    }
                   request.setAttribute("result", delete);
                modelBeans.deletebean(conn, name);
               
                }
                else{
                  response.sendRedirect("error.jsp");  
                }
                request.getRequestDispatcher("result.jsp").forward(request, response);
            }
        }
    }
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}