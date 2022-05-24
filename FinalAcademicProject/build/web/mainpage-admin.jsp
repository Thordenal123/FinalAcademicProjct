<%-- 
    Document   : mainpage-admin
    Created on : 05 22, 22, 4:49:36 PM
    Author     : Goldworth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
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
            

    <div class="box">
      <h1>Admin View Pannel</h1>
      <form method="post" action="ProductServlet">
      <button value="View all" name="viewall">
         View All the Available Products Products
      </button>
      </form>
    
      <form action="deleteitem.jsp">
      <button type="submit"> 
              Delete Items 
      </button>
      </form>
     
      <form action ="Logout">
      <button>
         Logout
      </button>
      </form>
    </div>
  </div>
</div>
    </body>
</html>
<style>
    body{
  background-image: url('https://thumbs.dreamstime.com/z/seamless-pattern-gears-steampunk-style-vintage-steampunk-movement-blue-background-wallpaper-postcard-179819123.jpg');
  padding:0;
  margin:0;
}
.vid-container{
  position:relative;
  height:100vh;
  overflow:hidden;
}
.bgvid.back {
  position: fixed; right: 0; bottom: 0;
  min-width: 100%; min-height: 100%;
  width: auto; height: auto; z-index: -100;
}
.inner {
  position: absolute;
}
.inner-container{
  width:400px;
  height:400px;
  position:absolute;
  top:calc(50vh - 200px);
  left:calc(50vw - 200px);
  overflow:hidden;
}
.bgvid.inner{
  top:calc(-50vh + 200px);
  left:calc(-50vw + 200px);
  filter: url("data:image/svg+xml;utf9,<svg%20version='1.1'%20xmlns='http://www.w3.org/2000/svg'><filter%20id='blur'><feGaussianBlur%20stdDeviation='10'%20/></filter></svg>#blur");
  -webkit-filter:blur(10px);
  -ms-filter: blur(10px);
  -o-filter: blur(10px);
  filter:blur(10px);
}
.box{
  position:absolute;
  height:100%;
  width:100%;
  font-family:Helvetica;
  color:#fff;
  background:rgba(0,0,0,0.13);
  padding:30px 0px;
}
.box h1{
  text-align:center;
  margin:30px 0;
  font-size:30px;
}
.box input{
  display:block;
  width:300px;
  margin:20px auto;
  padding:15px;
  background:rgba(0,0,0,0.2);
  color:#fff;
  border:0;
}
.box input:focus,.box input:active,.box button:focus,.box button:active{
  outline:none;
}
.box button{
  background:#742ECC;
  border:0;
  color:#fff;
  padding:10px;
  font-size:20px;
  width:330px;
  margin:20px auto;
  display:block;
  cursor:pointer;
}
.box button:active{
  background:#27ae60;
}
.box p{
  font-size:14px;
  text-align:center;
}
.box p span{
  cursor:pointer;
  color:#666;
}
    </style>