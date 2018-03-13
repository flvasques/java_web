<%-- 
    Document   : newjspexcluir-jogador
    Created on : 13/03/2018, 01:18:07
    Author     : Fernando Vasques
--%>
<%@page import="modelo.Jogador"%>
<%
    Jogador jogador =new Jogador();
    jogador.setId(Integer.parseInt(request.getParameterValues("id")[0]));
    jogador.Excluir();
    response.sendRedirect("./jogadores.jsp");
%>

