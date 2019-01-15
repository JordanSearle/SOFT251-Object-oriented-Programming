<%-- 
    Document   : Accounts
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

                         
                    <%
                        out.println("<h1>Doctors</h1>");
                        out.println(" <table class=\"table table-hover shadow\">");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println(" <th scope=\"col\">Forename</th>");
                        out.println("<th scope=\"col\">Surname</th>");
                        out.println("<th scope=\"col\">User Type</th>");
                        out.println("<th scope=\"col\">Total Rating</th>");
                        
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("<tbody>");
                        for (Doctor doctor : store.getDoctor()) {
                                out.println("<tr>");
                                    out.println("<td>"+doctor.getForename()+"</td>");
                                    out.println("<td>"+doctor.getSurname()+"</td>");
                                    out.println("<td>"+doctor.getClass().getSimpleName()+"</td>");                                    
                                    out.println("<td>"+doctor.getRating()+"</td>");
                                    
                                    out.println("</tr>");
                                    out.println("<tr>");                                    
                                    out.println("<td colspan=\"5\"><button class=\"collapsible\">View Ratings</button>");
                                    out.println("<div class=\"content\">");
                                     
                                    out.println(" <table class=\"table table-hover shadow\">");
                                            out.println("<thead>");
                                            out.println("<tr>");
                                            out.println(" <th scope=\"col\">Rating</th>");
                                            out.println("<th scope=\"col\">Feedback</th>");
                                            out.println("<th scope=\"col\">User</th>");
                                            if (ID.charAt(0)=='A') {
                                                    out.println("<th scope=\"col\">Add Feedback</th>");
                                                }
                                            out.println("</tr>");
                                            out.println("</thead>");
                                            out.println("<tbody>");
                                            for (int i = 0; i < doctor.getRatings().size(); i++) {
                                           out.println("<tr>");
                                            out.println("<td>"+doctor.getRatings().get(i).getRating()+"</td>");
                                            out.println("<td>"+doctor.getRatings().get(i).getFeedback()+"</td>");
                                            out.println("<td>"+doctor.getRatings().get(i).getPatientForename()+"</td>");
                                            if (ID.charAt(0)=='A') {
                                            out.println("<td><form action=\"addFeed\"id=\""+doctor.getiDnum()+"\">");
                                            out.println("<input type=\"hidden\"  name=\"ratingNum\" value=\""+i+"\">"); 
                                            out.println("<input type=\"hidden\"  name=\"IDnum\" value=\""+doctor.getiDnum()+"\">"); 
                                            out.println("Enter Feedback : <input type=\"text\" name=\"feedback\"  required>");  
                                            out.println("<input type=\"submit\" value=\"Add Feedback\">");
                                            out.println("</form></td>");
                                            }
                                            out.println("</tr>");
                                        }          
                                             out.println("<tr>");
                                            out.println("<td colspan=\"5\">"+"<button class=\"collapsible\">Add Rating</button>");
                                            out.println("<div class=\"content\">");
                                            if (ID.charAt(0)=='P') {
                                            out.println("<form action=\"addReview\"id=\""+doctor.getiDnum()+"\">");
                                            out.println("<input type=\"hidden\"  name=\"IDnum\" value=\""+doctor.getiDnum()+"\">"); 
                                            out.println("Enter Feedback : <input type=\"text\" name=\"feedback\"  required>"); 
                                            out.println("Enter Rating : <input type=\"number\" name=\"rating\" max=\"5\" required>");   
                                            out.println("</form>");
                                            out.println("<button type=\"submit\" form=\""+doctor.getiDnum()+"\" value=\""+doctor.getiDnum()+"\" name=\"medName\">"+"Add Review for : "+doctor.returnFullName()+"</button");
                                            out.println("</tr>");  
                                            }
                                            out.println("</div></td>");
                                            out.println("</tr>");
                                            
                                            
                                                  
                                    out.println("</table>");
                                    
                                    out.println("</div></td>");
                                    out.println("</tr>");
                        }        
                        
                    %>       
  </tbody>
        </table>      
        <% if (ID.charAt(0)!='P') {
                        out.println("<h1>Accounts</h1>");
                        out.println(" <table class=\"table table-hover shadow\">");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println(" <th scope=\"col\">Forename</th>");
                        out.println("<th scope=\"col\">Surname</th>");
                        out.println("<th scope=\"col\">User Type</th>");
                        out.println("<th scope=\"col\">Delete</th>");
                        
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("<tbody>");
                        if (ID.charAt(0)=='A') {
                        for (Doctor doctor : store.getDoctor()) {
                                out.println("<tr>");
                                    out.println("<td>"+doctor.getForename()+"</td>");
                                    out.println("<td>"+doctor.getSurname()+"</td>");
                                    out.println("<td>"+doctor.getClass().getSimpleName()+"</td>");   
                                    out.println("<td><form action=\"removeAccount\"id=\""+doctor.getiDnum()+doctor.getForename()+"\">");
                                    out.println("<button type=\"submit\" form=\""+doctor.getiDnum()+doctor.getForename()+"\" value=\""+doctor.getiDnum()+"\" name=\"medName\">Delete Account</button>");                                       out.println("</form>");
                                    out.println("</tr>");
                                    
                        }    
                        for (Secretary secretary : store.getSecretary()) {
                                out.println("<tr>");
                                    out.println("<td>"+secretary.getForename()+"</td>");
                                    out.println("<td>"+secretary.getSurname()+"</td>");
                                    out.println("<td>"+secretary.getClass().getSimpleName()+"</td>");   
                                    out.println("<td><form action=\"removeAccount\"id=\""+secretary.getiDnum()+secretary.getForename()+"\">");
                                    out.println("<button type=\"submit\" form=\""+secretary.getiDnum()+secretary.getForename()+"\" value=\""+secretary.getiDnum()+"\" name=\"medName\">Delete Account</button>");   
                                    out.println("</form>");
                                    out.println("</tr>");
                                    
                        } 
                        }
                        if (ID.charAt(0)=='S') {
                        for (Patient patient : store.getPatient()) {
                                out.println("<tr>");
                                    out.println("<td>"+patient.getForename()+"</td>");
                                    out.println("<td>"+patient.getSurname()+"</td>");
                                    out.println("<td>"+patient.getClass().getSimpleName()+"</td>");   
                                    out.println("<td><form action=\"removeAccount\"id=\""+patient.getiDnum()+patient.getForename()+"\">");
                                    out.println("<button type=\"submit\" form=\""+patient.getiDnum()+patient.getForename()+"\" value=\""+patient.getiDnum()+"\" name=\"medName\">Delete Account</button>");                                       out.println("</form>");
                                    out.println("</tr>");
                                    
                        } 
                        }
                        out.println("</tbody>");
                        out.println("</table>");
        }
           
        if (ID.charAt(0)=='A') {
        out.println("<form action=\"newUser\">\n" +
"                       <div class=\"row\">\n" +
"    <div class=\"col-4\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"  <div class=\"input-group-prepend\">\n" +
"    <label class=\"input-group-text\" for=\"inputGroupSelect01\">User Type</label>\n" +
"  </div>\n" +
"  <select class=\"custom-select\" name=\"userType\" required>\n" +
"    <option selected value=\"1\">Doctor</option>\n" +
"    <option value=\"2\">Secretary</option>\n" +
"    <option value=\"3\">Adminstrator</option>\n" +
"  </select>\n" +
"</div>\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"  </div>\n" +
"  <div class=\"row\">\n" +
"    <div class=\"col-sm\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"          <div class=\"input-group-prepend\">\n" +
"            <span class=\"input-group-text\" >Username</span>\n" +
"          </div>\n" +
"          <input type=\"text\" class=\"form-control\" placeholder=\"username\" name=\"username\" required>\n" +
"        </div>\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"  </div>\n" +
"    \n" +
"  <div class=\"row\">\n" +
"    <div class=\"col-sm\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"          <div class=\"input-group-prepend\">\n" +
"            <span class=\"input-group-text\" >Password</span>\n" +
"          </div>\n" +
"          <input type=\"password\" class=\"form-control\"  name=\"password\" required>\n" +
"        </div>\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"  </div>\n" +
"   <div class=\"row\">\n" +
"    <div class=\"col-sm\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"          <div class=\"input-group-prepend\">\n" +
"            <span class=\"input-group-text\" >Forename</span>\n" +
"          </div>\n" +
"          <input type=\"text\" class=\"form-control\" placeholder= \"forename\" name=\"Forename\" required>\n" +
"        </div>\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"  </div>\n" +
"           <div class=\"row\">\n" +
"    <div class=\"col-sm\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"          <div class=\"input-group-prepend\">\n" +
"            <span class=\"input-group-text\" >Surname</span>\n" +
"          </div>\n" +
"          <input type=\"text\" class=\"form-control\" placeholder=\"Surname\" name=\"Surname\" required>\n" +
"        </div>\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"  </div>  \n" +
"  <div class=\"row\">\n" +
"    <div class=\"col-4\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"          <div class=\"input-group-prepend\">\n" +
"            <span class=\"input-group-text\">Date of Birth</span>\n" +
"          </div>\n" +
"            <input type=\"date\" class=\"form-control\" name=\"DOB\" required>\n" +
"        </div>\n" +
"    </div>\n" +
"  </div>\n" +
"  <div class=\"row\">\n" +
"    <div class=\"col-8\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"          <div class=\"input-group-prepend\">\n" +
"            <span class=\"input-group-text\" >Address Line One</span>\n" +
"          </div>\n" +
"            <input type=\"text\" class=\"form-control\" placeholder=\"Address Line One\" name=\"address\" required>\n" +
"        </div>\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"  </div>\n" +
"  <div class=\"row\">\n" +
"    <div class=\"col-8\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"          <div class=\"input-group-prepend\">\n" +
"            <span class=\"input-group-text\">Address Line Two</span>\n" +
"          </div>\n" +
"          <input type=\"text\" class=\"form-control\" placeholder=\"Address Line Two\" name=\"addressTwo\">\n" +
"        </div>\n" +
"    </div>\n" +
"    <div class=\"col-sm\">\n" +
"    </div>\n" +
"  </div>\n" +
"          <div class=\"row\">\n" +
"    <div class=\"col-4\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"          <div class=\"input-group-prepend\">\n" +
"            <span class=\"input-group-text\" >City</span>\n" +
"          </div>\n" +
"          <input type=\"text\" class=\"form-control\" placeholder=\"City\" name=\"City\" required>\n" +
"        </div>\n" +
"    </div>\n" +
"    <div class=\"col-4\">      \n" +
"        <div class=\"input-group mb-3\">\n" +
"          <div class=\"input-group-prepend\">\n" +
"            <span class=\"input-group-text\" >Postcode</span>\n" +
"          </div>\n" +
"          <input type=\"text\" class=\"form-control\" placeholder=\"Postcode\" name=\"Postcode\" required>\n" +
"        </div>\n" +
"    </div>\n" +
"  </div>\n" +
"        <input class=\"btn btn-primary\" type=\"submit\" value=\"Create Account\">\n" +
"  </form>");                
            }
                    %>       
 
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
