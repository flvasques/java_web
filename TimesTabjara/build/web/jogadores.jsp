<%-- 
    Document   : jogadores
    Created on : 13/03/2018, 00:00:57
    Author     : Fernando Vasques
--%>

<%@page import="modelo.Jogador"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="cabecalho.jsp"></jsp:include>
        <section class="container-fluid col-md-offset-1 col-md-12 col-sm-12">
            <a href="./novo-jogador.jsp" class="btn btn-primary"> Novo</a>
            <hr />
            <div class="well col-md-12 col-sm-12"><p class="col-md-offset-4 col-sm-offset-4">Jogadores Cadastrados!</p></div>
        <%
            ArrayList<Jogador> lista = Jogador.listarJogadores();    
        %>
            <table class="table">
                <tr>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
               <%
                     for(int i = 0; i < lista.size(); i++){
                         Jogador t = lista.get(i);
                %>
                <tr>
                    <td><%=t.getNome()%></td>
                    <td>
                        <a href="./novo-jogador.jsp?id=<%=t.getId()%>" class="btn btn-warning">Editar</a>
                        <a href="./excluir-jogador.jsp?id=<%=t.getId()%>" class="btn btn-danger">Excluir</a>
                    </td>  
                </tr>
                <%
                     }
                %>
            </table>
            
        </section>
        <jsp:include page="rodape.jsp"></jsp:include>
    </body>
