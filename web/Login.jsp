<%-- 
    Document   : Login
    Created on : 16/07/2019, 01:33:39
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LoginApp</title>
    </head>
    <body>
        <jsp:useBean id="usuario" class="negocio.Usuario" scope="session"/>
        <jsp:setProperty name="usuario" property="*"/>
        
        
        <form action = "Login.jsp" method="POST">
            ID:<br>
            <input type="text" name="id"/><br>
            Senha:<br>
            <input type="password" name="pwd"/><br>
            <input type="submit" name="bt" value="Login"/>
        </form>
    </body>
</html>
