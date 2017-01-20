<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - Plan</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--Import Google Icon Font-->
  <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
  <link rel="stylesheet" href="css/master.css" media="screen" title="no title">
</head>
<body>

<%@ include file="commonContent/header.jsp" %>

  <div class="container">
    <main>
      <div class="row">
        <div class="col s6">
          <h4>Plan du site Internet</h4>
          <ul><td> <a href="http://localhost:1234/Technoweb/Statistics">Suivi parcours</a> </td>	</ul>
          <ul><td> <a href="http://localhost:1234/Technoweb/">Offres d'emplois et de stages</a> </td> </ul>
 
          <ul> <td> <a href="http://localhost:1234/Technoweb/Apply">Demande de convention</a> </td> </ul>
          <ul> <td> <a href="http://localhost:1234/Technoweb/Profile">Mon profil</a> </td> </ul>
          <ul><td> <a href="http://localhost:1234/Technoweb/Research">Recherche</a> </td></ul>
        </div>
      </div>
    </main>
  </div>

<%@ include file="commonContent/footer.jsp" %>

  <!-- Compiled and minified JavaScript -->
  <script type="text/javascript">
    $(".button-collapse").sideNav();
  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script type="text/javascript">
  $('.button-collapse').sideNav({
    closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
    draggable: true // Choose whether you can drag to open on touch screens
  }
  );
  </script>
</body>
</html>
