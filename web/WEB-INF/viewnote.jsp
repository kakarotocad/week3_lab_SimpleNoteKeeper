<%-- 
    Document   : viewnote
    Created on : Oct 6, 2020, 11:48:03 AM
    Author     : 794980
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <div>
            <p><b>Title: ${title}</b> </p>   
            <p><b>Content: ${content}</b> </p> 
        </div>
        
        <a href="note?edit">edit</a>
        
    </body>
</html>
