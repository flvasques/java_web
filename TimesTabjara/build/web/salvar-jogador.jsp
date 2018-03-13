<%-- 
    Document   : salvar-jogador
    Created on : 13/03/2018, 01:23:39
    Author     : Fernando Vasques
--%>
<%@page import="modelo.Jogador"%>
<%
    Jogador jogador = new Jogador();
    jogador.setId(Integer.parseInt(request.getParameter("id")));
    jogador.setNome(request.getParameter("nome"));
    jogador.getMeutime().setId(Integer.parseInt(request.getParameter("time")));
    jogador.salvar();
    response.sendRedirect("./jogadores.jsp");
%>
