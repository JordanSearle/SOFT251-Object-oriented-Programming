<%-- 
    Document   : appointments
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
    if (session.getAttribute("username")==null) {
            response.sendRedirect("index.jsp");
            return;
    }
    String ID = String.valueOf(session.getAttribute("ID"));
    accountStore store = new accountStore();
    store = store.readObject();
    ArrayList<Appointment> tempStore = new ArrayList();
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
      <th scope="col">Duration (Mins)</th>
      <%
      if (ID.charAt(0)=='S'){
          out.println("<th scope=\"col\">Approve</th>");
      }
      if (ID.charAt(0)=='D'){
          out.println("<th scope=\"col\">Start Consultation</th>");
      }
      %>
    </tr>
  </thead>
  <tbody>
                         
                    <%
                if (ID.charAt(0)=='P') {
                    for (Patient patient : store.getPatient()) {  
                        if (patient.getiDnum().equals(ID)) {
                        for(Appointment appointment : patient.getAppointments()){
                            if (appointment.isCompleted()==false){      
                            DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
                            out.println("<tr>");
                            out.println("<td>"+appointment.getPatient().returnFullName()+"</td>");
                            out.println("<td>"+appointment.getDoctor().returnFullName()+"</td>");
                            out.println("<td>"+fmt.format(appointment.getStartTime())+"</td>");
                            out.println("<td>"+fmt.format(appointment.getFinishTime())+"</td>"); 
                            appointment.setDuration();
                            out.println("<td>"+appointment.getDuration()+"</td>");  
                            out.println("</tr>");
                        }}
                        }                             
                    }
                }
                else if (ID.charAt(0)=='D') {
                    tempStore.clear();
                    for (Doctor doc : store.getDoctor()) {        
                        if (doc.getiDnum().equals(ID)) {
                        for (int i = 0; i < doc.getAppointment().size(); i++) { 
                            if (doc.getAppointment().get(i).isCompleted()==false){  
                            DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
                            out.println("<tr>");
                            out.println("<td>"+doc.getAppointment().get(i).getPatient().returnFullName()+"</td>");
                            out.println("<td>"+doc.getAppointment().get(i).getDoctor().returnFullName()+"</td>");
                            out.println("<td>"+fmt.format(doc.getAppointment().get(i).getStartTime())+"</td>");
                            out.println("<td>"+fmt.format(doc.getAppointment().get(i).getFinishTime())+"</td>"); 
                            doc.getAppointment().get(i).setDuration();
                            out.println("<td>"+doc.getAppointment().get(i).getDuration()+"</td>");  
                            
                            out.println("<td><form action=\"consol\" method=\"post\" id=\""+i+"\">");
                            out.println("<button type=\"submit\" form=\""+i+"\" value=\""+i+"\" name=\"appCon\">"+"Start Appointment with : "+doc.getAppointment().get(i).getPatient().returnFullName()+"</button");
                            out.println("</form></td>");
                            
                            
                            out.println("</tr>");
                        }         
                        }}
                    }
                }
                    %>       
                    
  </tbody>
        </table>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">Add Appointment</button>
                    <a href="index.jsp"><button type="button" class="btn btn-primary">Return Home</button><a/>
  </div> 
        
        
          
            
    
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content p-3">
              <form action="appointments">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text" >Patient's ID</span>
                </div>
                <input type="text" class="form-control"aria-describedby="basic-addon3" name="PID"value="${ID}">
            </div>      
           <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <label class="input-group-text" for="inputGroupSelect01">Doctor ID</label>
                </div>
                <select class="custom-select" name="DID">
                  <option selected>Select Doctor</option>
                  <%
                  for (int i = 0; i < store.getDoctor().size(); i++) {
                          out.println("<option value=\""+i+"\">"+store.getDoctor().get(i).returnFullName()+"</option>");
                      }
                  %>
                </select>
             </div>         
            
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">Patient Notes</span>
                </div>
                <textarea class="form-control" aria-label="Patient Notes" name="pnotes"></textarea>
            </div>
                  
             <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">Start Date</span>
                </div>
                 <input type="datetime-local" class="form-control" aria-describedby="basic-addon3" name="sdate">
             </div>
                  
             <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">Finish Date</span>
                </div>
                 <input type="datetime-local" class="form-control"aria-describedby="basic-addon3" name="fdate">
             </div>
            <input type="submit" value="Submit" class="btn btn-primary"><button type="button" class="btn btn-primary ml-3"data-dismiss="modal">Cancel</button>
        </form>
          </div>
        
    </div>
  </div>
</div>        
            
            
             <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    

        </body>
</html>
