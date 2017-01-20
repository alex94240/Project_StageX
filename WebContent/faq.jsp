<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - FAQ </title>
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
        <div class="s2">
          <h4>FAQ</h4>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          <div id="popout" class="section scrollspy">
            <ul class="collapsible popout collapsible-accordion" data-collapsible="accordion">
              <li>
                <div class="collapsible-header active"><i class="material-icons">subtitles</i>Comment trouver mon stage ?</div>
                <div class="collapsible-body"><p>Plusieurs solutions s’offrent à vous : chercher sur internet (Indeed, L’Etudiant, JobTeaser etc…), se rendre dans les forums (Alliance+…), regarder les offres sur StageX. En effet de nombreuses entreprises postent régulièrement des offres de stages sur notre site.</p></div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">games</i>Que faire une fois que j’ai trouvé mon stage ?</div>
                <div class="collapsible-body"><p>Après vous être entendu avec votre futur employeur sur les termes du stage, veuillez remplir la demande de convention. Vous aurez besoin d’information relatives à l’entreprise dans laquelle vous allez travailler donc n’hésitez pas à demander les renseignements nécessaires à votre maitre de stage. La demande devra être validé par votre responsable de parcours, celle-ci doit donc rentrée dans le cadre de votre cursus à l’ISEP.</p></div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">library_books</i>Que faire si je n’ai pas trouvé de stage ?</div>
                <div class="collapsible-body"><p>Aller voir d’urgence Mr.Falconet, </p></div>
              </li>
              <li>
                <div class="collapsible-header"><i class="material-icons">info</i>Comment contacter un élève ?</div>
                <div class="collapsible-body"><p>Il suffit d’appuyer sur le bouton de recherche, il permet de rechercher tous les inscrits sur le site Internet. Après avoir trouvé un élève, l’utilisateur pourra accéder au mail de l’élève et pourra le contacter avec sa propre messagerie.</p></div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col s4 offset-s4">
          <a class="waves-effect waves-light btn btn-isep" href="contact.jsp"><i class="material-icons left">email</i>Autre question</a>
        </div>
      </div><br>
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
    