<%-- 
    Document   : newjsp
    Created on : Apr 22, 2014, 1:42:28 PM
    Author     : TOY
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="th.co.geniustree.training.test.serch.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="http://localhost:8080/test-serch/" target="_blank">HOME</a>
        <br/>
        <% 
            List<Data> mydto = (List<Data>)request.getAttribute("mydto");
            for(Data myData : mydto){
                out.println("ID : "+myData.getId()+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "DRUGCODE : " +myData.getDrugcode()+"<br/>");
            }
        %>
    </body>
</html>
