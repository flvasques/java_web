<%-- 
    Document   : index
    Created on : 04/03/2018, 00:55:42
    Author     : Fernando Vasques
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Time"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="cabecalho.jsp"></jsp:include>
        <section class="container-fluid col-md-offset-1 col-md-12 col-sm-12">
            <a href="./novo.jsp" class="btn btn-primary"> Novo</a>
            <hr />
            <div class="well col-md-12 col-sm-12"><p class="col-md-offset-4 col-sm-offset-4">Times Cadastrados!</p></div>
        <%
            ArrayList<Time> lista = Time.listarTimes();    
        %>
            <table class="table">
                <tr>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
               <%
                     for(int i = 0; i < lista.size(); i++){
                         Time t = lista.get(i);
                %>
                <tr>
                    <td><%=t.getNome()%></td>
                    <td>
                        <a href="./novo.jsp?id=<%=t.getId()%>" class="btn btn-warning">Editar</a>
                        <a href="./Excluir.jsp?id=<%=t.getId()%>" class="btn btn-danger">Excluir</a>
                    </td>  
                </tr>
                <%
                     }
                %>
            </table>
            
        </section>
        <jsp:include page="rodape.jsp"></jsp:include>
    </body>
</html>
