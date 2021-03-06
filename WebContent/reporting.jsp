<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - Suivi</title>
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
          <h4>Suivi de parcours</h4>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          <div class="stats">
            <!-- TODO : statistics pie charts (camembert) -->
            <ul>
                <li>Salaire moyen des étudiants en stage :
                	<span class="numbers center">${avgSalInternship}</span> 
                </li>
                <li>Salaire moyen des étudiants en entreprise :
                	<span class="numbers center">${avgSalJob}</span>  
                </li>
                <br>
                <li>Compagnies acceuillant les etudiants en stage : </li>
						
							<table class="bordered">
							

								<thead>
									<tr>
										<th data-field="company">Société</th>
										<th data-field="salary">Salaire moyen</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${companies}" var="company">
									<tr>
										<td>${company.companyName}</td>
										<td>${company.companyId}</td>
										
									</tr>
								</tbody>
								</c:forEach>
							</table>

					
          </div>
          
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
    