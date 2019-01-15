<%-- 
    Document   : request
    Created on : 08-Jan-2019, 16:49:07
    Author     : Jordan Searle
--%>
<%@page import="java.time.format.FormatStyle"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Classes.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%
    String ID=(String)session.getAttribute("ID");
    if (session.getAttribute("username")!=null) {
        if (ID.charAt(0)!='S') {
            response.sendRedirect("index.jsp");
            return;
        }            
    }
    else if (session.getAttribute("username")==null){
        response.sendRedirect("index.jsp");
            return;
    }
    accountStore store = new accountStore();
    store = store.readObject();
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            td{
                cursor: pointer;
            }
        </style>
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
        <a class="nav-link" href="index.html"><button type="button" class="btn btn-primary">HOME</button></a>
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
        <br>
        <div class="container"> 
<table class="table table-hover shadow">
  <thead>
    <tr>
      <th scope="col">Patient Name</th>
      <th scope="col">Doctors name</th>
      <th scope="col">Start Time</th>
      <th scope="col">Finish Time</th>
      <th scope="col">Duration</th>
      <%
      if (ID.charAt(0)=='S'){
          out.println("<th scope=\"col\">Approve</th>");
      }
      %>
    </tr>
  </thead>
  <tbody>
                         
                    <%
                    try{
                        if (ID.charAt(0)=='S') {
                    
                    for (Secretary sec : store.getSecretary()) {                        
                        for(int i = 0; i < sec.getAppointments().size(); i++){       
                            DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
                            out.println("<tr>");
                            out.println("<td>"+sec.getAppointments().get(i).getPatient().returnFullName()+"</td>");
                            out.println("<td>"+sec.getAppointments().get(i).getDoctor().returnFullName()+"</td>");
                            out.println("<td>"+fmt.format(sec.getAppointments().get(i).getStartTime())+"</td>");
                            out.println("<td>"+fmt.format(sec.getAppointments().get(i).getFinishTime())+"</td>"); 
                            sec.getAppointments().get(i).setDuration();
                            out.println("<td>"+sec.getAppointments().get(i).getDuration()+"</td>");  
                            
                            out.println("<td><form action=\"appApprove\" method=\"post\" id=\""+i+"\">");
                            out.println("<button type=\"submit\" form=\""+i+"\" value=\""+i+"\" name=\"app\">"+"Approve : "+sec.getAppointments().get(i).getPatient().returnFullName()+"</button");
                            out.println("</form></td>");
                            
                            
                            out.println("</tr>");
                        }                             
                    }
                }}
                    catch(IndexOutOfBoundsException e){
                         System.out.println("Exception occurred");
                         return;
                    }
                    %>       
                    
  </tbody>
        </table>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">Add Appointment</button>
                    <a href="index.jsp"><button type="button" class="btn btn-primary">Return Home</button><a/>
<table class="table table-hover shadow">
  <thead>
    <tr>
      <th scope="col">Patient Name</th>
      <th scope="col">Patient Address</th>
      <th scope="col">Patient City</th>
      <th scope="col">Approve</th>
    </tr>
  </thead>
  <tbody>
                         
                    <%
                    if (ID.charAt(0)=='S') {
                        out.println("<h1>Approve new Patient</h1>");
                    for (Secretary sec : store.getSecretary()) {                       
                        for(int i = 0; i < sec.getApprovePatient().size(); i++){      
                            out.println("<tr>");
                            out.println("<td>"+sec.getApprovePatient().get(i).returnFullName()+"</td>");
                            out.println("<td>"+sec.getApprovePatient().get(i).getAddressLineOne()+"</td>");
                            out.println("<td>"+sec.getApprovePatient().get(i).getCity()+"</td>"); 
                            
                            out.println("<td><form action=\"accApprove\" method=\"post\" id=\""+sec.getApprovePatient().get(i).getiDnum()+"\">");
                            out.println("<button type=\"submit\" form=\""+sec.getApprovePatient().get(i).getiDnum()+"\" value=\""+i+"\" name=\"app\">"+"Approve : "+sec.getApprovePatient().get(i).returnFullName()+"</button");
                            out.println("</form></td>");
                            
                            
                            out.println("</tr>");
                        }                            
                    }
                    
                }
                    %>       
                    
  </tbody>
        </table>       
                    <table class="table table-hover shadow">
  <thead>
    <tr>
      <th scope="col">Patient Name</th>
      <th scope="col">Patient Address</th>
      <th scope="col">Patient City</th>
      <th scope="col">Approve</th>
    </tr>
  </thead>
  <tbody>
                         
                    <%
                    if (ID.charAt(0)=='S') {
                        out.println("<h1>Approve Patient Deletion</h1>");
                    for (Secretary sec : store.getSecretary()) {                       
                        for(int i = 0; i < sec.getApproveDelPatient().size(); i++){     
                            out.println("<tr>");
                            out.println("<td>"+sec.getApproveDelPatient().get(i).returnFullName()+"</td>");
                            out.println("<td>"+sec.getApproveDelPatient().get(i).getAddressLineOne()+"</td>");
                            out.println("<td>"+sec.getApproveDelPatient().get(i).getCity()+"</td>"); 
                            
                            out.println("<td><form action=\"accApproveDel\" method=\"post\" id=\""+sec.getApproveDelPatient().get(i).getiDnum()+"\">");
                            out.println("<button type=\"submit\" form=\""+sec.getApproveDelPatient().get(i).getiDnum()+"\" value=\""+sec.getApproveDelPatient().get(i).getiDnum()+"\" name=\"medName\">"+"Delete : "+sec.getApproveDelPatient().get(i).returnFullName()+"</button");
                            out.println("</form></td>");
                            
                            
                            out.println("</tr>");
                        }                            
                    }
                    }
                    %>       
                    
  </tbody>
        </table> 
  </div> 
        
       <table class="table table-hover shadow">
  <tbody>
                         
                    <%
                    try{
                        if (ID.charAt(0)=='S') {
                    
                    for (Doctor sec : store.getDoctor()) {                        
                            out.println("<tr>");
                            out.println("<td>"+sec.getUsername()+"</td>");
                            out.println("</tr>");                    
                    }
                }}
                    catch(IndexOutOfBoundsException e){
                         System.out.println("Exception occurred");
                         return;
                    }
                    %>       
                    
  </tbody>
        </table> 
          
            
    

</div>        
            
            
             <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    

        </body>
</html>
