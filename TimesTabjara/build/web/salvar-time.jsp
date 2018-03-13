<%-- 
    Document   : salvar-time
    Created on : 04/03/2018, 02:57:52
    Author     : Fernando Vasques
--%>

<%@page import="modelo.Time"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  Time time  = new Time();
  time.setId(Integer.parseInt(request.getParameter("id")));
  time.setNome(request.getParameter("nome"));
  time.salvar();
  response.sendRedirect("./index.jsp");
%>