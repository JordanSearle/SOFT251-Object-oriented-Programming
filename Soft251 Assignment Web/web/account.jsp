<%-- 
    Document   : Account
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
        if (ID.charAt(0)!='P') {
            response.sendRedirect("index.jsp");
            return;
        }            
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    accountStore store = new accountStore();
    store = store.readObject();
    Patient pStore = new Patient();
    if ((ID.charAt(0)=='P')) {
        for (Patient patient : store.getPatient()) {
            if (patient.getiDnum().equals(ID)) {
                    pStore = patient;
            }
    }
    }
%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>${name}</title>
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
      <h1>Account Details</h1>
<form action="saveUser">
  <div class="row">
    <div class="col-sm">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Username</span>
          </div>
          <input type="text" class="form-control" value=<%out.println("\""+pStore.getUsername()+"\"");%> name="username" readonly required>
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
          <input type="text" class="form-control" value= <%out.println("\""+pStore.getForename()+"\"");%> name="Forename" required>
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
          <input type="text" class="form-control" value=<%out.println("\""+pStore.getSurname()+"\"");%> name="Surname" required>
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
          <input type="text" class="form-control" value=<%out.println("\""+pStore.getGender().getGender()+"\"");%>  name="Pgender" required>
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
            <input type="text" class="form-control" name="DOB" readonly value=<%out.println("\""+pStore.getDateOfBirth().format(formatter)+"\"");%> readonly >
        </div>
    </div>
    <div class="col-2">
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Age</span>
          </div>
          <input type="text" class="form-control" name="Age" readonly value=<%out.println("\""+pStore.getAge()+"\"");%> >
        </div>
    </div>
  </div>
  <div class="row">
    <div class="col-8">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Address Line One</span>
          </div>
            <input type="text" class="form-control" value=<%out.println("\""+pStore.getAddressLineOne()+"\"");%> name="address" required>
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
          <input type="text" class="form-control" value=<%out.println("\""+pStore.getAddressLineTwo()+"\"");%> name="addressTwo">
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
          <input type="text" class="form-control" value=<%out.println("\""+pStore.getCity()+"\"");%> name="City" required>
        </div>
    </div>
    <div class="col-4">      
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span class="input-group-text" >Postcode</span>
          </div>
          <input type="text" class="form-control" value=<%out.println("\""+pStore.getPostcode() +"\"");%> name="Postcode" required>
        </div>
    </div>
  </div>
        <input class="btn btn-primary" type="submit" value="Save Changes">
  </form>
        <form action="delAcc" class="pt-3 pb-3">  
        <input class="btn btn-primary" type="submit" value="Delete Account">
        </form>
        <h1>Past Appointments</h1>
        <table class="table table-hover shadow">
  <thead>
    <tr>
      <th scope="col">Patient Name</th>
      <th scope="col">Doctors name</th>
      <th scope="col">Doctor notes</th>
      <th scope="col">Duration (Mins)</th>
    </tr>
  </thead>
  <tbody>
                         
                    <%
                if (ID.charAt(0)=='P') {
                    for (Patient patient : store.getPatient()) {     
                        if (patient.getiDnum().equals(ID)) {
                        for(Appointment appointment : patient.getAppointments()){
                            if (appointment.isCompleted()) {
                                out.println("<tr>");
                                out.println("<td>"+appointment.getPatient().returnFullName()+"</td>");
                                out.println("<td>"+appointment.getDoctor().returnFullName()+"</td>");
                                out.println("<td>"+appointment.getDoctorNotes()+"</td>");
                                appointment.setDuration();
                                out.println("<td>"+appointment.getDuration()+"</td>");  
                                out.println("</tr>");
                                }    
                            }
                        }
                    }
                }
                    %>       
                    
  </tbody>
        </table>
                    
   <h1>Prescriptions</h1>
        <table class="table table-hover shadow">
  <thead>
    <tr>
      <th scope="col">Medicine Name</th>
      <th scope="col">Dosage</th>
      <th scope="col">Quantity</th>
      <th scope="col">Prescribed Status</th>
    </tr>
  </thead>
  <tbody>
                         
                    <%
                if (ID.charAt(0)=='P') {
                    for (Patient patient : store.getPatient()) {   
                        if (patient.getiDnum().equals(ID)) {
                            for(Prescription prescription : patient.getPrescription()){
                                System.out.println(prescription.getMedicine().size());
                                for (Medicine med : prescription.getMedicine()) {                                  
                                    out.println("<tr>");
                                    out.println("<td>"+med.getName()+"</td>");
                                    out.println("<td>"+med.getDosage()+"</td>");
                                    out.println("<td>"+med.getQuantity()+"</td>"); 
                                    out.println("<td>"+med.getPrescribed()+"</td>"); 
                                    out.println("</tr>");     
                                }
                            }
                        }
                    }
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
