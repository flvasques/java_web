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
                    Cadastro de Usuário
                </p>
            </div>
        <form action="${linkTo[LoginController].casdastrar()}" method="post">
            <table class="table">
                <tr>
                    <td>Login</td>
                    <td>
                        <input type="hidden" class="form-control" name="usuario.id" value="0"/>
                        <input type="text" class="form-control" name="usuario.login" validate="required" autofocus/>                        
                    </td>
                </tr>
                <tr>
                    <td>Senha</td>
                    <td>
                        
                        <input type="password" class="form-control" id="psswd" name="usuario.senha" validate="required"/>
                    </td>
                </tr>
                <tr>
                    <td>Repita a Senha</td>
                    <td>
                        <input type="password" class="form-control" name=usuario.confirmacao" onblur="avaliar(this.value)" validate="required"/>
                    </td>
                </tr>
            </table>
            <br />
            <input type="submit" class="btn btn-success" name="enviar" value="Salvar">
        </form>  
            <script>
              function avaliar(pss){
                  if(pss != document.querySelector("#psswd").value){
                      alert("Campos senha e repita a senha diferentes favor corrija.");
                  }
              }
            </script>
    </section>
        <jsp:include page="../rodape.jsp"></jsp:include>
</html>

