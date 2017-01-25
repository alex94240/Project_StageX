<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - Offres</title>
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
          <h4>Offres d'emplois et de stages</h4>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          <table class="highlight responsive-table">
            <thead>
              <tr>
                  <th data-field="id">Société</th>
                  <th data-field="name">Type de poste</th>
                  <th data-field="price">Type</th>
                  <th data-field="time">Durée</th>
              </tr>
            </thead>

            <tbody>
              
              <c:forEach items="${offers}" var="offer">
				<tr>					
                <td>${offer.contactFirstName}</td>
                <td><c:out value="${offer.title}" /></td>
                <td><c:out value="${offer.job}" /></td>
                <td><c:out value="${offer.duration}" /></td>
                
                <td style="text-align:left">
                  <!-- Modal Trigger -->
                  <a class="waves-effect waves-light btn btn-isep" href="#modal1">Voir</a>

                  <!-- Modal Structure -->
                  <div id="modal1" class="modal">
                    <div class="modal-content">
                    
                      <h4>${offer.title}-${offer.contactFirstName}</h4>
                      <p> ${offer.description}</p>
                      <p><b>Profil:</b> ${offer.profileRequirement}</p>
                      <p><b>Compétences</b>: ${offer.abilityRequirement }</p>
                      <p><b>Rémunération:</b> ${offer.salary }</p>
                      </c:forEach>
                    </div>
                    <div class="modal-footer">
                      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
                    </div>
                  </div>
                  </td>
				</tr>
              
               
            </tbody>
          </table>
        </div>
      </div>
      <div class="row">
        <div class="col s4 offset-s4">
          <a class="waves-effect waves-light btn btn-isep" href="post-offer.jsp"><i class="material-icons left">email</i>Poster une offre</a>
        </div>
      </div>
    </main>
  </div>

<%@ include file="commonContent/footer.jsp" %>

  <!--Import jQuery before materialize.js-->
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="js/materialize.min.js"></script>

  <script type="text/javascript">
  $(document).ready(function(){
  // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
  $('.modal').modal();
  });
  </script>
  <script type="text/javascript">
  $('.button-collapse').sideNav({
    closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
    draggable: true // Choose whether you can drag to open on touch screens
  }
  );
  </script>
</body>
</html>
