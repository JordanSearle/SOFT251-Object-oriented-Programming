<%-- 
    Document   : History
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
    if (session.getAttribute("username")==null){
        response.sendRedirect("index.jsp");
        return;
    }
    String ID=(String)session.getAttribute("ID");
    if (session.getAttribute("username")!=null) {
        if (ID.charAt(0)!='D'&&ID.charAt(0)!='S') {
            response.sendRedirect("index.jsp");
            return;
        }            
    }
    accountStore store = new accountStore();
    store = store.readObject();
%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>${name}</title>
        <style>
            .content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
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
  <div class="container p-3">
        <h1>Patient History</h1>
        <table class="table table-hover shadow">
  <thead>
    <tr>
      <th scope="col">Forename</th>
      <th scope="col">Surname</th>
      <th scope="col">User Type</th>
      <th scope="col">More Information</th>
    </tr>
  </thead>
  <tbody>
                         
                    <%
                        for (Patient patient : store.getPatient()) {
                                out.println("<tr>");
                                    out.println("<td>"+patient.getForename()+"</td>");
                                    out.println("<td>"+patient.getSurname()+"</td>");
                                    out.println("<td>"+patient.getClass().getSimpleName()+"</td>");
                                    out.println("</tr>");
                                    out.println("<tr>");                                    
                                    out.println("<td colspan=\"4\"><button class=\"collapsible\">View Appointments and Medication</button>");
                                    out.println("<div class=\"content\">");
                                    out.println("<h1>Appointments</h1>"); 
                                    if (ID.charAt(0)=='D') {
                                    for(Appointment appointment : patient.getAppointments()){
                                        out.println("<table>");
                                        out.println("<tr>");
                                        out.println("<th scope=\"col\">Patient Name</th>");
                                        out.println("<th scope=\"col\">Doctor Name</th>");
                                        out.println("<th scope=\"col\">Doctor Notes</th>");
                                        out.println("<th scope=\"col\">Completed</th>");
                                        out.println("<th scope=\"col\">Duration</th>");
                                        out.println("</tr>");
                                        out.println("<tr>");
                                        out.println("<td>"+appointment.getPatient().returnFullName());
                                        out.println("<td>"+appointment.getDoctor().returnFullName());
                                        out.println("<td>"+appointment.getDoctorNotes());
                                        out.println("<td>"+appointment.isCompleted());
                                        appointment.setDuration();
                                        out.println("<td>"+appointment.getDuration());  
                                        out.println("</tr>");
                                        out.println("</table>"); 
                                        
                                        }}
                                            out.println("<h1>Prescription Medication</h1>"); 
                                         out.println("<table>");
                                            out.println("<tr>");
                                            out.println("<th scope=\"col\">Medicine Name</th>");
                                            out.println("<th scope=\"col\">Dosage</th>");
                                            out.println("<th scope=\"col\">Quantity</th>");
                                            out.println("<th scope=\"col\">Prescribe</th>");
                                            int number = 0;
                                            for(Prescription pre : patient.getPrescription()){
                                                
                                                for(Medicine med : pre.getMedicine()){
                                                    if (med.getPrescribed()==false) {
                                                            
                                                    out.println("</tr>");
                                                    out.println("<tr>");
                                                    out.println("<td>"+med.getName());
                                                    out.println("<td>"+med.getDosage());
                                                    out.println("<td>"+med.getQuantity());
                                                    if (med.getPrescribed()==false) {  
                                                    out.println("<td>");
                                                    out.println("<form action=\"preMed\"id=\""+med.getName()+"\">"); 
                                                    out.println("<input type=\"text\" name=\"stockName\" readonly value=\""+med.getName()+"\">");   
                                                    out.println("<input type=\"text\" name=\"idNUM\" readonly value=\""+patient.getiDnum()+"\">");   
                                                    out.println("<input type=\"text\" name=\"medNum\" readonly value=\""+number+"\">");  
                                                    out.println("</form>");
                                                    out.println("<button type=\"submit\" form=\""+med.getName()+"\" value=\""+med.getName()+"\" name=\"medName\">"+"Prescribe "+med.getName()+"</button");
                                                    number++;
                                                    }
                                                    }
                                                }
                                            }
                                            out.println("</tr>");
                                            out.println("</table>");
                                    
                                    out.println("</div></td>");
                                    out.println("</tr>");
                                    
                        }
                    %>       
  </tbody>
        </table>      
</div>
  
  
        
  
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script>
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>

        
    </body>
</html>
