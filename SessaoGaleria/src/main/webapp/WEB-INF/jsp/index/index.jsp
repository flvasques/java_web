<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <jsp:include page="../cabecalho.jsp"></jsp:include>
       <section class="container-fluid col-md-offset-1 col-md-12 col-sm-12">
            <hr />
            <div class="well col-md-12 col-sm-12"><p class="col-md-offset-4 col-sm-offset-4">Imagens</p></div>
            <table class="table">
                <c:forEach var="imagem" items="${imagemList}">
                    <tr>
                        <td></td>
                    </tr>
                </c:forEach>
            </table>
    </section>
        <jsp:include page="../rodape.jsp"></jsp:include>
    </body>
</html>