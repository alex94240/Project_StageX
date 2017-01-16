<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Stage X - Recherche</title>
<meta charset="utf-8">
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/master.css" media="screen"
	title="no title">
</head>

<body>

	<%@ include file="commonContent/header.jsp"%>

	<div class="container">
		<main>
		<div class="row">
			<div class="col s6">
				<h4>Recherche</h4>
			</div>
		</div>
		<div class="row card-panel">
			<form class="col s12" action="ResearchServlet">
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">play_for_work</i> <input
							id="icon_prefix" type="text" class="validate" name="keyword">
						<label for="icon_prefix">Input something you want research</label>
					</div>
				</div>
				<div class="col s3 offset-s5">
					<input class="waves-effect waves-light btn btn-isep" type="submit"
						name="submit" value="Suivant">
				</div>
			</form>
		</div>
	</div>
	</main>
	</div>

	<%@ include file="commonContent/footer.jsp"%>

	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
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
