<%-- 
    Document   : index
    Created on : 08-Jan-2019, 14:59:49
    Author     : Jordan Searle
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="Classes.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Welcome!</title>
  </head>
  <body>
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
  <a class="navbar-brand" ><button type="button" class="btn btn-primary active" aria-pressed="true">WELCOME ${fn:toUpperCase(name)}</button></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp"><button type="button" class="btn btn-primary">HOME</button></a>
      </li>
      <li class="nav-item">
          <%
              if (session.getAttribute("navApp")!=null) {
                      out.println(session.getAttribute("navApp"));
                  }              
          %>
      </li>  
      <li class="nav-item">
        <%
            if (session.getAttribute("navStock")!=null) {
                    out.println(session.getAttribute("navStock"));
                }            
        %>
      </li>  
      <li class="nav-item"><%
          if (session.getAttribute("patient")!=null) {
                    out.println(session.getAttribute("patient"));
                }  
                
      %>
      <li class="nav-item">                
          <%
              if (session.getAttribute("username")!=null) {
                      out.println("<a class=\"nav-link\" href=\"accounts.jsp\"><button type=\"button\" class=\"btn btn-primary\">USERS</button></a>"); 
                  }               
          %>
      </li>
      </li> 
      <li class="nav-item"><%
          String ID=(String)session.getAttribute("ID");
          if (session.getAttribute("username")!=null&&ID.charAt(0)!='P'&&ID.charAt(0)!='A'){
              out.println("<a class=\"nav-link\" href=\"history.jsp\"><button type=\"button\" class=\"btn btn-primary\">HISTORY</button></a>");
          }        
      %>
      </li> 
    </ul>
      <span class="navbar-text">
<%
    if (session.getAttribute("username")==null){
        out.println("<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModal\">SIGN IN</button>");
    }
    else{
        out.println("<form action=\"logout\">");
        out.println("<input type=\"submit\"value=\"SIGN OUT\"class=\"btn btn-primary\">");
        out.println("</form>");
    }
%>
      
    </span>
  </div>
  
</nav>
<div class="container p-3">
<form action="createAccount">
  <div class="row">
    <div class="col-sm">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Username</span>
          </div>
          <input type="text" class="form-control" placeholder="username" name="username" required>
        </div>
    </div>
    <div class="col-sm">
    </div>
    <div class="col-sm">
    </div>
  </div>
    
  <div class="row">
    <div class="col-sm">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Password</span>
          </div>
          <input type="password" class="form-control"  name="password" required>
        </div>
    </div>
    <div class="col-sm">
    </div>
    <div class="col-sm">
    </div>
  </div>
   <div class="row">
    <div class="col-sm">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Forename</span>
          </div>
          <input type="text" class="form-control" placeholder= "forename" name="Forename" required>
        </div>
    </div>
    <div class="col-sm">
    </div>
    <div class="col-sm">
    </div>
  </div>
           <div class="row">
    <div class="col-sm">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Surname</span>
          </div>
          <input type="text" class="form-control" placeholder="Surname" name="Surname" required>
        </div>
    </div>
    <div class="col-sm">
    </div>
    <div class="col-sm">
    </div>
  </div>
                    <div class="row">
    <div class="col-sm">      
        <div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Options</label>
  </div>
  <select class="custom-select" name="Bgender" required>
    <option selected>Gender...</option>
    <option value="0">Male</option>
    <option value="1">Female</option>
  </select>
</div>
    </div>
    <div class="col-sm">
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text">Preferred Gender</span>
          </div>
          <input type="text" class="form-control" placeholder="Gender"  name="Pgender">
        </div>
    </div>
    <div class="col-sm">
    </div>
  </div>
  <div class="row">
    <div class="col-4">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text">Date of Birth</span>
          </div>
            <input type="date" class="form-control" name="DOB" required>
        </div>
    </div>
  </div>
  <div class="row">
    <div class="col-8">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Address Line One</span>
          </div>
            <input type="text" class="form-control" placeholder="Address Line One" name="address" required>
        </div>
    </div>
    <div class="col-sm">
    </div>
  </div>
  <div class="row">
    <div class="col-8">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text">Address Line Two</span>
          </div>
          <input type="text" class="form-control" placeholder="Address Line Two" name="addressTwo">
        </div>
    </div>
    <div class="col-sm">
    </div>
  </div>
          <div class="row">
    <div class="col-4">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >City</span>
          </div>
          <input type="text" class="form-control" placeholder="City" name="City" required>
        </div>
    </div>
    <div class="col-4">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Postcode</span>
          </div>
          <input type="text" class="form-control" placeholder="Postcode" name="Postcode" required>
        </div>
    </div>
  </div>
        <input class="btn btn-primary" type="submit" value="Create Account">
  </form>
  </div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form action="login">
              Enter Username : <input type="text" name="uname" required><br>
              Enter Password : <input type="password" name="pass" required><br>
              <input type="submit" value="login">
                                      
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save</button>
      </div>
    </div>
  </div>
</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
