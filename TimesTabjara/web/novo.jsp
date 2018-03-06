<%-- 
    Document   : novo
    Created on : 04/03/2018, 01:47:20
    Author     : Fernando Vasques
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="cabecalho.jsp"></jsp:include>
        <section class="container-fluid col-md-offset-1 col-md-12 col-sm-12">
            <a href="./index.jsp" class="btn btn-primary"> Voltar</a>
            <hr />
            <div class="well col-md-12 col-sm-12"><p class="col-md-offset-4 col-sm-offset-4">Times Cadastrados!</p></div>
            <form action="./salvar-time.jsp" method="post">
            <table class="table">
                <tr>
                    <td><label>Nome</label></td>
                    <td><input type="text" class="form-control" maxlength="255" size="50"  name="nome" placeholder="Nome do Clube" autofocus></td>
                </tr>
            </table>
                <input type="submit" class="btn btn-success" name="enviar" value="ENVIAR">
            </form>
        </section>
        <jsp:include page="rodape.jsp"></jsp:include>
</html>
