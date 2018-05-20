<%-- 
    Document   : cabecalho
    Created on : 04/03/2018, 01:33:58
    Author     : Fernando Vasques
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Galeria</title>
    </head>
    <body>
        <header class="well col-md-12 col-sm-12">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <!-- Brand/logo -->
                <a class="navbar-brand" href="#">
                    <p>Galeria</p>
                </a>
                <!-- Links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${linkTo[IndexController].index()}">Imagens</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${linkTo[LoginController].cadastro()}">Cadastrar</a>
                    </li>
                </ul>
            </nav>
            <br><br>
        </header>
</html>