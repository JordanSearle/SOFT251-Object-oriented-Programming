<%-- 
    Document   : Consultation
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
        if (ID.charAt(0)!='D') {
            response.sendRedirect("index.jsp");
            return;
        }            
    } 
    
    System.out.println(session.getAttribute("num"));
    String number=String.valueOf(session.getAttribute("num"));
    int num = Integer.valueOf(number);
    accountStore store = new accountStore();
    store = store.readObject();
    Appointment app = new Appointment();
    for (Doctor doc : store.getDoctor()) {
            if (doc.getiDnum().equals(ID)) {
                 app = doc.getAppointment().get(num);
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
        <h1>Consultation Details</h1>
        <%
        out.println("<h4>"+app.getPatient().returnFullName()+"</h4>");
        out.println("<h4>"+app.getPatientNotes()+"</h4>");        
        %>
        <form action="conSave">
            Consultation Notes : <textarea  name="notes" required></textarea> <br>  
            <button id="btnPres" type="button">Add Prescription</button>
            <div id="pres">                
            </div>
            
             <input type="submit" value="Save and Close">
        </form>
        
</div>
  
  
        
  
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script>
            var colArray = new Array();
             colArray = [];
        <% for (int i=0; i<store.getStock().get(0).getMedicine().size(); i++) { %>
         colArray[<%= i %>] = "<%= store.getStock().get(0).getMedicine().get(i).getName() %>"; 
        <% } %>
            var j=0;
   
        $("#btnPres").click(function(){
                   
         
            $("#pres").append("<div class=\"p-3\">");
            $("#pres").append("Select Medicine : <select name=\"medNum\"id=\""+j+"\">");
            for (i = 0; i < colArray.length; i++) {
                $("#"+j).append("<option value=\""+i+"\">"+colArray[i]+"</option>");
            }
            $("#pres").append("</select><br>");
            $("#pres").append("<br>Dosage : <input type=\"text\" name=\"preDosage\" required>");
        $("#pres").append("  Quantity : <input type=\"text\" name=\"quantity\" required><br>");
        $("#pres").append("</div>");
        j++;
      });
        
    </script>

        
    </body>
</html>
