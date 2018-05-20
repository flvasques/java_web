<%-- 
    Document   : editar
    Created on : 20/05/2018, 17:21:22
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
                    Cadastro de Usuário
                </p>
            </div>
        <p>${mensagem}</p>
        <form action="${linkTo[ImagemController].salvar()}" enctype="multipart/form-data" method="post">
            <table class="table">
                <tr>
                    <td>Foto</td>
                    <td>
                        <input type="hidden" class="form-control" name="imagem.uploader" value="0"/>
                        <input type="file" class="form-control" name="usuario.imagem.arquivo" validate="required"/>                        
                    </td>
            </table>
            <br />
            <input type="submit" class="btn btn-success" name="enviar" value="Salvar">
        </form>  
    </section>
        <jsp:include page="../rodape.jsp"></jsp:include>
</html>
