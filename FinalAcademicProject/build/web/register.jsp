<%-- 
    Document   : register
    Created on : 05 21, 22, 9:40:38 PM
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
    <div class="center">
        <form action ="SignupControl" method="POST">
 
                <label for="username">Username: </label>
                <input id="user" type="text" class="input" name="username" placeholder="Username"> <br><br>
                <label for="password">Password: </label>
                <input id="pass" type="password" class="input" data-type="password" name="password" placeholder="Password"> <br><br>
                <label for="password">Confirm Password: </label>
                <input id="pass" type="password" class="input" data-type="password" name="confirmPassword" placeholder="Confirm Password"><br>

                 <label for="role">Role: </label>
                 <select name="role">
                     <option>Admin
                     <option>Guest
                 </select> <br><br>
                <center>
                <input type="submit" value="Sign Up">
                
                 <a href="login.jsp">Log In</a>
                </center> <br>
            <img src="<%=request.getRequestURL().toString().replace("/register.jsp", "")%>/stickyImg" style="display:none"/>
            <img src="<%=request.getRequestURL().toString().replace("/register.jsp", "")%>/stickyImg" />
            <br><input name="captchaAns" placeholder="Captcha"/>
        </form>
    </div>
              
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
    
    
    
    
    
    
    
    
    