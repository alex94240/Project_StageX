<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - Poster une offre</title>
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
          <h4>Poster une offre</h4>
        </div>
      </div>
      <div class="row card-panel">
        <form class="col s12">
          <div class="row">
            <div class="input-field col s2">
              <p>
                <input class="with-gap" name="group" type="radio" id="test1"/>
                <label for="test1">Stage</label>
              </p>
            </div>
            <div class="input-field col s2">
              <p>
                <input class="with-gap" name="group" type="radio" id="test2"/>
                <label for="test2">CDI</label>
              </p>
            </div>
            <div class="input-field col s2">
              <p>
                <input class="with-gap" name="group" type="radio" id="test3"/>
                <label for="test3">CDD</label>
              </p>
            </div>
            <div class="input-field col s2">
              <p>
                <input class="with-gap" name="group" type="radio" id="test4"/>
                <label for="test4">Alternance</label>
              </p>
            </div>
          </div><br>
          <hr>
          <div class="row">
            <div class="col s2">
              <h5>Entreprise</h5>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">perm_identity</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix">Nom entreprise</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">perm_identity</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix">Lien du site Internet</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea"></textarea>
              <label for="icon_prefix2">Description entreprise</label>
            </div>
          </div>
          <div class="row">
            <div class="col s2">
              <h5>Contact</h5>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">perm_identity</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix">Nom contact</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">perm_identity</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix">Prénom contact</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">perm_identity</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix">Email</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">perm_identity</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix">Poste</label>
            </div>
          </div>
          <div class="row">
            <div class="col s2">
              <h5>Offre</h5>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">perm_identity</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix">Titre de l'offre</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea"></textarea>
              <label for="icon_prefix2">Description de l'offre</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea"></textarea>
              <label for="icon_prefix2">Description du profil recherché</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">mode_edit</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix2">Lieu de l'offre</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">mode_edit</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix2">Rénumération</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">mode_edit</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix2">Compétences recherchées</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">mode_edit</i>
              <input id="icon_prefix" type="text" class="validate">
              <label for="icon_prefix2">Durée de l'offre</label>
            </div>
          </div>
          <div class="row">
            <div class="col s3 offset-s5">
              <a class="waves-effect waves-light btn btn-isep"><i class="material-icons left">email</i>Envoyer</a>
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
</body>
</html>
