<%-- 
    Document   : appointments
    Created on : 08-Jan-2019, 16:49:07
    Author     : Jordan Searle
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  if (session.getAttribute("username")==null ) {
          response.sendRedirect("index.jsp");
  }
               
         %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Welcome : ${name}
    </body>
</html>
