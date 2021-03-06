<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <c:choose>
        	<c:when test="${student.studentId == sessionScope.userid}"><h4>Mon profil</h4></c:when>
        	<c:otherwise><h4>Profil Elève</h4></c:otherwise>	
        </c:choose>
        </div>
      </div>
      <div class="row">
        <div class="col s3">
          <div class="row">
            <div class="col s12">
              <img class="circle" src="${student.picture }" width="200">
            </div>
          </div>
          <div class="row">
            <div class="s12">
              	${student.telphone}
            </div>
          </div>
          <div class="row">
            <div class="s12">
				${student.email}
            </div>
          </div>
        </div>
        <div class="col s6 offset-s3">
          <div class="row">
            <div class="col s4">
              <h4>${student.firstName}</h4>
            </div>
            <div class="col s8">
              <h4>${student.lastName}</h4>
            </div>
          </div>
          <div class="row">
            <div class="col s4">
              Étudiant
            </div>
            <div class="col s8">
              Promotion ${student.garde}
            </div>
          </div>
          <div class="row">
            <div class="col s12">
              ${student.studentSpe}
            </div>
          </div>
          </br>
           <div class="row">
	        <div class="col s12">
	          <div class="card amber lighten-4">
	            <div class="card-content">
	              <span class="card-title">Developpeur Web</span>
	              <p>Atos - 01/2014 à 05/2016</p>
	              <p>
					<ul>
					    <li>Développement de sites Web / Backoffice</li>
					    <li>Applications métiers Intranet / Extranet PHP</li>
					    <li>SEO / SMO / Web marketing</li>
					</ul>
	              </p>
	            </div>
	          </div>
	        </div>
	      </div>
          
		  <div class="row">
            <div class="col s10 offset-s1">
                <a href="ProfileExperience" class="waves-effect waves-light btn btn-isep"><i class="material-icons left">add</i>Ajouter une expérience</a>
              
            </div>
          </div>
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
                <input type="file" name="file">
              </div>
              <div class="file-path-wrapper">
                <input class="file-path validate" type="text">
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="row">
        <div class="col s6 offset-s4">
          <a href="UpdateProfilServlet" class="waves-effect waves-light btn btn-isep"><i class="material-icons left">email</i>Modifier mes informations</a>
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
