<%-- 
    Document   : novo-jogador
    Created on : 13/03/2018, 00:08:52
    Author     : Fernando Vasques
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Time"%>
<%@page import="modelo.Jogador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    Jogador jogador = new Jogador();
    if(request.getParameter("id") != null){
        jogador.carregar(Integer.parseInt(request.getParameter("id")));
    }
    ArrayList<Time> lista = Time.listarTimes();
%>
<html>
    <jsp:include page="cabecalho.jsp"></jsp:include>
        <section class="container-fluid col-md-offset-1 col-md-12 col-sm-12">
            <a href="./jogadores.jsp" class="btn btn-primary"> Voltar</a>
            <hr />
            <div class="well col-md-12 col-sm-12"><p class="col-md-offset-4 col-sm-offset-4">Jogador Ficha Cadastral</p></div>
            <form action="./salvar-jogador.jsp" method="post">
            <table class="table">
                <tr>
                    <td><label>Nome</label></td>
                    <td><input type="hidden" name="id" value="<%=jogador.getId() %>">
                      <input type="text" class="form-control" maxlength="255" size="50"  name="nome" placeholder="Nome do Jogador" value="<%=jogador.getNome() %>" autofocus></td>
                </tr>
                <tr>
                    <td>Times</td>
                    <td>
                        <select name="time" required="true">
                            <option value="">Escolha um Time</option>
                            <%
                                for(int i = 0; i < lista.size(); i++){
                                    if(lista.get(i).getId() == jogador.getId()){
                             %>
                                        <option value="<%=lista.get(i).getId() %>" selected><%=lista.get(i).getNome() %></option>
                             <%
                                    }else{
                            %>
                                        <option value="<%=lista.get(i).getId() %>"><%=lista.get(i).getNome() %></option>
                            <% 
                                    }
                                }
                            %>
                        </select>
                    </td>
                </tr>
            </table>
                <input type="submit" class="btn btn-success" name="enviar" value="ENVIAR">
            </form>
        </section>
        <jsp:include page="rodape.jsp"></jsp:include>
</html>
