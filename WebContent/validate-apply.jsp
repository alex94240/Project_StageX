<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - Valider les conventions</title>
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
          <h4>Demandes de convention de stages en attente de validation</h4>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          <table class="highlight responsive-table">
            <thead>
              <tr>
                  <th data-field="id">Élève</th>
                  <th data-field="name">Société</th>
                  <th data-field="price">Début</th>
              </tr>
            </thead>

            <tbody>
              
              <tr>
              <c:forEach items="${apply}" var="apply">
									<tr>
										<td>${apply.bossFax}  ${apply.applyRequirement}   </td>
										<td><c:out value="${apply.pricipleSteps}" /></td>
										<td><c:out value="${apply.startDate}" /></td>
			  
										<td style="text-align:right">
                  <!-- Modal Trigger -->
                  <a class="waves-effect waves-light btn btn-isep" href="#modal3">Voir</a>

                  <!-- Modal Structure -->
                  <div id="modal3" class="modal">
                    <div class="modal-content">
                      <h4>Description du stage</h4>
                      <p>${apply.decription}</p>
                      <p>${apply.applyGoal}</p>
                    </div>
                    <div class="modal-footer">
                    	<form method="post" action="ValidateApplyServlet">
	
			 				<table >
		                    	<button  class=" modal-action modal-close waves-effect waves-green btn-flat" type="button" name="validate" value="1">Valider</button>
		                        <!-- <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Valider</a> -->
		                        <a href="ValidateApplyServlet" class=" modal-action modal-close waves-effect waves-green btn-flat">refuser</a>
	                    	</table>
						</form>
                    </div>
                  </div>
                </td>
									</tr>
								</c:forEach>
						
              </tr>
              
            </tbody>
          </table>
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
