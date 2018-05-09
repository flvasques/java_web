<%-- 
    Document   : editar
    Created on : 06/05/2018, 20:18:30
    Author     : Fernando Vasques
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <!DOCTYPE html>
    <jsp:include page="../cabecalho.jsp"></jsp:include>
    <section class="container-fluid col-md-offset-1 col-md-12 col-sm-12">
        <a href="${linkTo[IndexController].index()}" class="btn btn-primary"> Voltar</a>
        <hr />
            <div class="well col-md-12 col-sm-12">
                <p class="col-md-offset-4 col-sm-offset-4">
                    <c:choose>
                       <c:when test="${aluno.getMatricula() == 0}">Cadastrar Novo Aluno</c:when>
                       <c:otherwise>Alterar dados do Aluno</c:otherwise>
                    </c:choose>
                </p>
            </div>
        
        <form action="${linkTo[AlunoController].salvar()}" method="post">
            <table>
                <tr>
                    <td>Nome</td>
                    <td>
                        <input type="hidden" name="aluno.matricula" value="${aluno.getMatricula()}"/>
                        <input type="text" name="aluno.nome" value="${aluno.getNome()}" validate="required" autofocus/>
                    </td>
                </tr>
            </table>
            <br />
            <input type="submit" class="btn btn-success" name="enviar" value="Salvar">
        </form>  
    </section>
        <jsp:include page="../rodape.jsp"></jsp:include>
</html>
