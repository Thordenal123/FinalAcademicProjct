/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.AccountModel;
import Securities.Security;
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
import javax.servlet.http.HttpSession;
import nl.captcha.Captcha;

/**
 *
 * @author Goldworth
 */
public class LoginControl extends HttpServlet {

     Connection conn;
   String conPassword; 
    @Override
    public void init(ServletConfig config) throws ServletException{
       super.init(config);
       
      
        try {
            Class.forName(config.getInitParameter("jdbcClassName"));
            System.out.println("jdbcClassName: " + config.getInitParameter("jdbcClassName"));
            String username = config.getInitParameter("dbUserName");
            String password = config.getInitParameter("dbPassword");
            String url = config.getInitParameter("jdbcDriverURL");
            conn = DriverManager.getConnection(url.toString(), username, password);
            
            
        } catch (SQLException sqle) {
            System.out.println("SQLException error occured - "
                    + sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        request.setCharacterEncoding("UTF-8");
        String answer = request.getParameter("captchaAns");
       
        HttpSession session = request.getSession();
        session.setAttribute("username",user);
        Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
        
        if(captcha.isCorrect(answer)){
            
          List<AccountModel> userAccount = AccountModel.loginModel(conn, user); 
          
          if(!(userAccount.isEmpty())){ 
             
             for(AccountModel mod : userAccount)
             {
                conPassword = Security.decrypt(mod.getPassword());
             }
             
             if(conPassword.equals(pass))
             {
                response.sendRedirect("mainpage.jsp"); 
             }
             
             else
             { 
                 response.sendRedirect("login.jsp"); 
             }
             
          }
          else
          { 
              response.sendRedirect("index.jsp");
              return;
          }
        }
        
        else
        { 
            response.sendRedirect("login.jsp");
            return;
        }
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
