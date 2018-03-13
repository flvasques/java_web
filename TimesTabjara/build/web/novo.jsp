<%-- 
    Document   : novo
    Created on : 04/03/2018, 01:47:20
    Author     : Fernando Vasques
--%>

<%@page import="modelo.Time"%>
<%@page import="modelo.Jogador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    Time time = new Time();
    if(request.getParameter("id") != null){
        time.carregar(Integer.parseInt(request.getParameter("id")));
    }
%>
<html>
    <jsp:include page="cabecalho.jsp"></jsp:include>
        <section class="container-fluid col-md-offset-1 col-md-12 col-sm-12">
            <a href="./index.jsp" class="btn btn-primary"> Voltar</a>
            <hr />
            <div class="well col-md-12 col-sm-12"><p class="col-md-offset-4 col-sm-offset-4">Time Ficha Cadastral</p></div>
            <form action="./salvar-time.jsp" method="post">
            <table class="table">
                <tr>
                    <td><label>Nome</label></td>
                    <td><input type="hidden" name="id" value="<%=time.getId() %>">
                        <input type="text" class="form-control" maxlength="255" size="50"  name="nome" placeholder="Nome do Clube" value="<%=time.getId() %>" autofocus></td>
                </tr>
            </table>
                <input type="submit" class="btn btn-success" name="enviar" value="ENVIAR">
            </form>
                <p><strong>Jogadores Ligados</strong></p>
                <ul class="list-unstyled">
                    <%
                        for(int i = 0; i < time.getJogadores().size(); i++){
                          out.println("<li>" + time.getJogadores().get(i).getNome() + "</li>");
                        }
                    %>
                </ul>    
        </section>
        <jsp:include page="rodape.jsp"></jsp:include>
</html>
