<%-- 
    Document   : index
    Created on : May 24, 2022, 1:23:40 PM
    Author     : Thomas Jefferson Qiu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <div class="topnav">
        <label for="username">Username: </label>
                <input id="user" type="text" class="input" name="username" placeholder="Username">
        <label for="password">Password: </label>
                <input id="pass" type="password" class="input" data-type="password" name="password" placeholder="Password">
        <img src="<%=request.getRequestURL().toString().replace("/index.jsp", "")%>/stickyImg" style="display:none"/>
        <img src="<%=request.getRequestURL().toString().replace("/index.jsp", "")%>/stickyImg"/>
            <input name="captchaAns" placeholder="Captcha"/>
        <input type="submit" value="Login"/>
        <form action ="register.jsp">
      <button>
         Register
      </button>
        <center>
            <img src="https://github.com/Thordenal123/FinalAcademicProjct/blob/main/Logo%201.jpg?raw=true" 
         width="360" 
         height="300"
         border: 50px solid #555;
            />
        
    </body>
</html>

<style>
body {
 background-image: url('https://thumbs.dreamstime.com/z/seamless-pattern-gears-steampunk-style-vintage-steampunk-movement-blue-background-wallpaper-postcard-179819123.jpg');
 background-size: 100%;
 background-repeat: no-repeat;
}