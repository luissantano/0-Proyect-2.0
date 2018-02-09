<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.iesemilidarder.projectozero.ReadDB" %>
<%@ page import="com.iesemilidarder.dao.Restaurants" %>
<!doctype html>
<html lang="ca">
<head>
    <title>Restaurants</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">

</head>
<body>
<!-- Navigation bar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Restaurants</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Inici <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="test">Enllaç 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="test">Enllaç 2</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="index.jsp">
            <input class="form-control mr-sm-2" type="text" placeholder="Cercar" aria-label="Cercar" name="cercar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cercar</button>
        </form>
    </div>
</nav>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3"> Ravioli , Ravioli what's in the pocketoli </h1>
            <p>Aixó es una pàgina per l'assignatura d'en Miquel de Java.</p>
            <p><a class="btn btn-primary btn-lg" href="test" role="button">Learn more &raquo;</a></p>
        </div>
    </div>

    <div class="container">
        <hr>

        <!--A aquesta part del codi   , feim que mostri el nom , tipus , adreça , el telèfon i la pàgina web -->
<%

    Restaurants restaurant = (Restaurants) request.getAttribute("id");

    out.println("<p>" + "<img class='img-fluid' src='" + restaurant.getImage() + "'>"  + "</p>");

    out.println(

                    "<p>" + restaurant.getName() + "</p>" +
                    "<p>" + restaurant.getType() + "</p>" +
                    "<p>" + restaurant.getAddress() + "</p>" +
                    "<p>" + restaurant.getTelephone() + "</p>" +
                    "<p>" + restaurant.getWebsite() + "</p>"
    );
//Utilitzarem un for per que tregui totes les opinions que s'han redactat sobre el restaurant en questió.
    for (String opinio :restaurant.getOpinion()) {
        out.println("<p>" + opinio + "</p>");
    }
%>
        <hr>
    </div> <!-- /container -->

</main>

<footer class="container">
    <p>&copy; Lluis Santano Santiago</p>
</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>