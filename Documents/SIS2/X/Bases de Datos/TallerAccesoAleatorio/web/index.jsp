<%-- 
    Document   : index
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Saludo</title>
    </head>
    <body>
               
      <%
      String respuesta = 
        (String)request.getAttribute("respuesta");
        if(respuesta != null && respuesta.length()>0)
        {
        %>
          <H1><%=respuesta%> </h1>
        <%}%>
        
        <%--Action: URL del Servlet --%>
        <form action="HolaMundo" method="POST">
            <input type="text" name="saludo"/>
            <input type="submit" name="enviar"/>
        </form>
        <h1>Resultado Lista </h1>
        <%
            
        ArrayList<String> array =(ArrayList) 
               request.getAttribute("array");
        if(array!=null){
        for (String elemento : array){
        %>
        <h2><%=elemento%>
        <%        
        }}
        %>
        
        
      </body>
</html>
