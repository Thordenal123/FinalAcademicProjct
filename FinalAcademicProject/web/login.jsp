<%-- 
    Document   : login
    Created on : 05 22, 22, 4:29:22 PM
    Author     : Goldworth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="post" action="LoginServlet">
            
            <input id="user" type="text" class="input" name="username" placeholder="Username">
            
            
            <input id="pass" type="password" class="input" data-type="password" name="password" placeholder="Password">
            
            <br> <br>
           <img src="<%=request.getRequestURL().toString().replace("/login.jsp", "")%>/stickyImg" style="display:none"/>
           <img src="<%=request.getRequestURL().toString().replace("/login.jsp", "")%>/stickyImg"/>
            <input name="captchaAns" placeholder="Captcha"/>
            
            <br>
            <input type="submit" value="Login"/>
        </form>
        <br> <br>
        <a href="index.jsp">Sign Up</a>
    </body>
</html>
<style>
body{
  background-image: url('https://thumbs.dreamstime.com/z/seamless-pattern-gears-steampunk-style-vintage-steampunk-movement-blue-background-wallpaper-postcard-179819123.jpg');
  padding:0;
  margin:0;
}
