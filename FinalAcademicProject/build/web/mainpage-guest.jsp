<%-- 
    Document   : mainpage-guest
    Created on : May 24, 2022, 1:12:49 PM
    Author     : Thomas Jefferson Qiu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <img src="https://github.com/Thordenal123/FinalAcademicProjct/blob/main/Logo%201.jpg?raw=true" 
         width="360" 
         height="300"
         border: 50px solid #555;
            />
        </title>
    </head>
    <body>  
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            
            response.setHeader("Proagma", "no-cache");
            
            response.setHeader("Expires", "0");
            
            if(session.getAttribute("username") == null)
            {
                response.sendRedirect("index.jsp");
            }
            %>
            
            Welcome Guest ${username}
            <br>
          A PDF print out of your information is on file:///C:\Netbeans\FinalAcademicProject/Guest.pdf
            <br>
            Password Decrypted: ${depassword}
            <form action ="Logout">
                <input type="submit" value="Logout">
               <a href="C:\Netbeans\FinalAcademicProject/Guest.pdf">Your Information</a>
               </form>
            <a href="view.jsp"> View All </a>
    </body>
</html>
