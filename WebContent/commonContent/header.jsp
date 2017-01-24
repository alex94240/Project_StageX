<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<div class="navbar-fixed">
  <nav>
    <div class="nav-wrapper">
      <div class="">
        <a href="home.jsp" class="brand-logo">Stage X</a>
        <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
        <ul class="right hide-on-med-and-down">
        	<c:if test= "${sessionScope.usertype == 'enseignant'}">
         		<li><a href="Statistics">Suivi parcours</a></li>
          	</c:if>
          <li><a href="OffersServlet">Offres d'emplois et de stages</a></li>
          <li><a href="apply-internship-agreement">Demande de convention</a></li>
          <c:if test= "${sessionScope.usertype == 'eleve'}">
          	<li><a href="ProfileServlet">Profil</a></li>
          </c:if>
          <li><a href="LogoutServlet">Déconnexion</a></li>
          <li><a class="waves-effect waves-light btn btn-isep" href="ResearchServlet">Recherche</a></li>
          <li><img src="img/isep.png" alt="logo" width="100px" class="logo-isep"/></li>
        </ul>
      </div>
    </div>
  </nav>
</div>
<ul class="side-nav" id="slide-out">
	<c:if test= "${sessionScope.usertype == 'enseignant'}">
		<li><a href="Statistics">Suivi parcours</a></li>
    </c:if>
    <li><a href="OffersServlet">Offres d'emplois et de stages</a></li>
  <li><a href="apply-internship-agreement">Demande de convention</a></li>
  <c:if test= "${sessionScope.usertype == 'eleve'}">
  	<li><a href="ProfileServlet">Profil</a></li>
  </c:if>  
  <li><a href="LogoutServlet">Déconnexion</a></li>
</ul>
