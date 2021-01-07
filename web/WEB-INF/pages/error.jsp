<%-- 
    Document   : error
    Created on : 04.01.2021, 18:41:31
    Author     : munte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <center>
            <h1>ERROR!</h1>
            <h2><%=exception.getMessage() %> <br /></h2>
        </center>
    </body>
</html>
