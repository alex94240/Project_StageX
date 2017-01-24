<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - Modifier son profil</title>
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
          <h4>Modifier son profil</h4>
        </div>
      </div>
      <div class="row card-panel">
      
		<form class="col s12" action="UpdateProfilServlet" method="post">
          <div class="row">       
		    <div class="input-field col s6">
		      <i class="material-icons prefix">account_circle</i>
		      <input disabled value="${student.firstName }" id="first_name2" type="text" class="validate">
		      <label class="active" for="first_name2">Prénom</label>
		    </div>        
	        <div class="input-field col s6">
	          <i class="material-icons prefix">account_circle</i>
	          <input disabled value="${student.lastName }" id="last_name" type="text" class="validate">
	          <label for="last_name">Nom</label>
	        </div>
      	  </div>
      	  <div class="row"> 
			  <div class="input-field col s12">
			    <select name="grade">
			      <option value="" disabled selected>Choisir une option</option>
			      <c:forEach begin="1990" end="${year+5}" step="1" var="i">
			      	<option value="${i}"><c:out value="${i }"/></option>
			      </c:forEach>
			    </select>
			    <label>Sélectionne ta promotion</label>
			  </div>
		  </div>
		  
	      <div class="row">
	        <div class="input-field col s12">
	          <i class="material-icons prefix">email</i>
	          <input value="${student.email}" id="email" name="email" type="email" class="validate">
	          <label for="email">Email</label>
	        </div>
	      </div>  
	      <div class="row">
	        <div class="input-field col s12">
	          <i class="material-icons prefix">phone</i>
	          <input value="${student.telphone}" id="phone" name="telphone" type="text" class="validate">
	          <label for="phone">Téléphone</label>
	        </div>
	      </div>
	      <div class="row">
	        <div class="input-field col s12">
	        	<select name="parcours">
			      <option value="" disabled selected>Choisir une option</option>
			      <option value="information system">Système d'information</option>
			      <option value="software">Génie Logiciel</option>
			      <option value="business intelligence">Business Intelligence</option>
			      <option value="telecom">Télécom et IoT</option>
			      <option value="network">Réseau</option>
			      <option value="health">Numérique et Santé</option>
			    </select>
	          <label>Parcours</label>
	        </div>
	      </div>
          <div class="row">
            <div class="col s3 offset-s5">
            <i class="material-icons left">email</i>
            <input class="waves-effect waves-light btn btn-isep" type="submit" name="submit" value="Envoyer">
            </div>
          </div>
        </form>
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
  <script type="text/javascript"> 
  $(document).ready(function() {
    $('select').material_select();
  });
  </script>
</body>
</html>
