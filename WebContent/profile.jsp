<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - Profil</title>
  <meta charset="utf-8">
  <!--Import Google Icon Font-->
  <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link rel="stylesheet" href="css/master.css" media="screen" title="no title">
</head>
<body>

<%@ include file="commonContent/header.jsp" %>

  <div class="container">
    <main>
      <div class="row">
        <div class="col s6">
          <h4>Mon profil</h4>
        </div>
      </div>
      <div class="row">
        <div class="col s3">
          <div class="row">
            <div class="col s12">
              <img class="circle" src="img/victor.jpg" width="200">
            </div>
          </div>
          <div class="row">
            <div class="s12">
              06.70.76.73.80
            </div>
          </div>
          
          <c:forEach var="parametre" items="${ paramValues }"> 

         <ul>

            <%-- Affiche la clé de la Map paramValues,

            qui correspond concrètement au nom du paramètre. --%>

            <li><b><c:out value="${ parametre.key }"/></b> :</li>


            <%-- Parcourt le tableau de String[] associé à la clé traitée, 

            qui correspond à la liste de ses valeurs. --%>

            <c:forEach var="value" items="${ parametre.value }">

               <%-- Affiche chacune des valeurs pour la clé donnée --%>

               <c:out value="${ value }"/>   

            </c:forEach>

         </ul>

      </c:forEach>
          
      <!--<c:forEach var="profilHelene" items="${ parametre.profilHelene }">

               <%-- Affiche chacune des valeurs pour la clé donnée --%>

               <c:out value="${ value }"/>   -->

            
          <div class="row">
            <div class="s12">
              vely@juniorisep.com
            </div>
          </div>
        </div>
        <div class="col s4 offset-s4">
          <div class="row">
            <div class="col s4">
              <h4>Victor</h4>
            </div>
            <div class="col s4">
              <h4>ELY</h4>
            </div>
          </div>
          
             <!--</c:forEach> -->
          
          <div class="row">
            <div class="col s4">
              Étudiant
            </div>
            <div class="col s8">
              Promotion 2018
            </div>
          </div>
          <div class="row">
            <div class="col s12">
              Systèmes d'Information
            </div>
          </div>
          <form action="">
            <div class="file-field input-field">
              <div class="btn btn-isep">
                <span>Image</span>
                <input type="file">
              </div>
              <div class="file-path-wrapper">
                <input class="file-path validate" type="text">
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="row">
        <div class="col s4">
          <form action="">
            <div class="file-field input-field">
              <div class="btn btn-isep">
                <span>CV</span>
                <input type="file">
              </div>
              <div class="file-path-wrapper">
                <input class="file-path validate" type="text">
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="row">
        <div class="col s4">
          <form action="">
            <div class="file-field input-field">
              <div class="btn btn-isep">
                <span>Lettre de motivation</span>
                <input type="file">
              </div>
              <div class="file-path-wrapper">
                <input class="file-path validate" type="text">
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="row">
        <div class="col s4 offset-s8">
          <a class="waves-effect waves-light btn btn-isep"><i class="material-icons left">email</i>Enregistrer</a>
        </div>
      </div>
    </main>
  </div>

<%@ include file="commonContent/footer.jsp" %>

  <!--Import jQuery before materialize.js-->
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="js/materialize.min.js"></script>
  <script type="text/javascript">
  $('.button-collapse').sideNav({
    closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
    draggable: true // Choose whether you can drag to open on touch screens
  }
  );
  </script>
</body>
</html>
