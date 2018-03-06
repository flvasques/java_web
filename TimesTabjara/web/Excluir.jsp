<%-- 
    Document   : Excluir
    Created on : 04/03/2018, 03:26:29
    Author     : Fernando Vasques
--%>

<%@page import="modelo.Time"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Time time =new Time();
    time.setId(Integer.parseInt(request.getParameterValues("id")[0]));
    time.Excluir();
    response.sendRedirect("./index.jsp");
%>
