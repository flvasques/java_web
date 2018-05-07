<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <jsp:include page="../cabecalho.jsp"></jsp:include>
       <section class="container-fluid col-md-offset-1 col-md-12 col-sm-12">
            <a href="${linkTo[AlunoController].editar(0)}" class="btn btn-primary">Novo</a>
            <hr />
            <div class="well col-md-12 col-sm-12"><p class="col-md-offset-4 col-sm-offset-4">Liatagem de Alunos</p></div>
            <table class="table">
                <tr>
                    <th>Matrícula</th>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
                <c:forEach var="aluno" items="${alunosList}">
                    <tr>
                        <td>${aluno.getMatricula()}</td>
                        <td>${aluno.getNome()}</td>
                        <td><a href="${linkTo[AlunoController].editar(aluno.matricula)}" class="btn btn-warning">Editar</a></td>
                    </tr>
                </c:forEach>
            </table>
    </section>
        <jsp:include page="../rodape.jsp"></jsp:include>
    </body>
</html>