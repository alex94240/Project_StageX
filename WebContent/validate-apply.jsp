<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                  <th data-field="price">Durée</th>
              </tr>
            </thead>

            <tbody>
              <tr>
                <td>Victor ELY</td>
                <td>Exxon Mobile</td>
                <td>6 mois</td>
                <td style="text-align:right">
                  <!-- Modal Trigger -->
                  <a class="waves-effect waves-light btn btn-isep" href="#modal1">Voir</a>

                  <!-- Modal Structure -->
                  <div id="modal1" class="modal">
                    <div class="modal-content">
                      <h4>Modal Header</h4>
                      <p>A bunch of text</p>
                    </div>
                    <div class="modal-footer">
                    	<button class=" modal-action modal-close waves-effect waves-green btn-flat" type="button"></button>
                      <!-- <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a> -->
                    </div>
                  </div>
                </td>

              </tr>
              <tr>
                <td>Hélène ROGER</td>
                <td>Alten</td>
                <td>6 mois</td>
                <td style="text-align:right">
                  <!-- Modal Trigger -->
                  <a class="waves-effect waves-light btn btn-isep" href="#modal2">Voir</a>

                  <!-- Modal Structure -->
                  <div id="modal2" class="modal">
                    <div class="modal-content">
                      <h4>Modal Header</h4>
                      <p>A bunch of text</p>
                    </div>
                    <div class="modal-footer">
                      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Myléna CAUCHE</td>
                <td>EY</td>
                <td>5 mois</td>
                <td style="text-align:right">
                  <!-- Modal Trigger -->
                  <a class="waves-effect waves-light btn btn-isep" href="#modal3">Voir</a>

                  <!-- Modal Structure -->
                  <div id="modal3" class="modal">
                    <div class="modal-content">
                      <h4>Modal Header</h4>
                      <p>A bunch of text</p>
                    </div>
                    <div class="modal-footer">
                    	<!-- Copy this one !!!! -->
                    	<button class=" modal-action modal-close waves-effect waves-green btn-flat" type="button" name="validate" value="1">Valider</button>
                      <!-- <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Valider</a> -->
                      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">refuser</a>
                    </div>
                  </div>
                </td>
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
