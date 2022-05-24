<%-- 
    Document   : login
    Created on : 05 22, 22, 4:29:22 PM
    Author     : Goldworth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

     <div class="form-box">
        
        <img src="https://github.com/Thordenal123/FinalAcademicProjct/blob/main/Logo%201.jpg?raw=true" 
         width="360" 
         height="300"
         border: 50px solid #555;
            />
    
    
    
    <body style="text-align:center;" >
        <nav class="navbar">
            <div class="content">
                <div class="logo">
                    
                </div>  
         <label for="click" class="menu-btn">
         <i class="fas fa-bars"></i>
         </label>

      </nav>                          
    <body>
        <h1>Login</h1>
        
        <form method="POST" action="LoginControl">
            
            <label for="username">Username: </label>
                <input id="user" type="text" class="input" name="username" placeholder="Username"> <br><br>
            <label for="password">Password: </label>
                <input id="pass" type="password" class="input" data-type="password" name="password" placeholder="Password"> <br><br>
            
            <br>
           <img src="<%=request.getRequestURL().toString().replace("/login.jsp", "")%>/stickyImg" style="display:none"/>
           <img src="<%=request.getRequestURL().toString().replace("/login.jsp", "")%>/stickyImg"/> <br>
            <input name="captchaAns" placeholder="Captcha"/>
            <br>
            <input type="submit" value="Login"/>
            <a href="register.jsp">Sign Up</a>    
        </form>
        
    </body>
              
</div>
    </body>
    <style>
body {
 background-image: url('https://thumbs.dreamstime.com/z/seamless-pattern-gears-steampunk-style-vintage-steampunk-movement-blue-background-wallpaper-postcard-179819123.jpg');
 background-size: 100%;
 background-repeat: no-repeat;
 
}.form-box {
	background-color: rgba(255, 255, 255, 0.5);
	margin: auto auto;
	padding: 40px;
	border-radius: 5px;
	box-shadow: 0 0 10px #000;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	width: 500px;
	height: 540px;
}
