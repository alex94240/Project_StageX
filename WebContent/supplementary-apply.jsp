<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - Contact</title>
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
          <h4>Demande de convention</h4>
        </div>
      </div>
      <div class="row card-panel">
        <form class="col s12" action="ApplyServlet" method="post">
       	  <% 
        	String group = request.getParameter("group");
      		String nom = request.getParameter("nom");
      		String prenom = request.getParameter("prenom");
        	String numOfSocialSecurity = request.getParameter("numOfSocialSecurity");
        	String parcours = request.getParameter("parcours");
        	String personAddress = request.getParameter("personAddress");
        	String personEmail = request.getParameter("personEmail");
        	String personTelephone = request.getParameter("personTelephone");
        	
        	String siretNum = request.getParameter("siretNum");
        	String CodeAPE = request.getParameter("CodeAPE");
        	String companyName = request.getParameter("companyName");
      		String companyAddress = request.getParameter("companyAddress");
      		String applyAddress = request.getParameter("applyAddress");
        	String receptionName = request.getParameter("receptionName");
        	String applyPhone = request.getParameter("applyPhone");
        	String companyFax = request.getParameter("companyFax");
        	String chargeContact = request.getParameter("chargeContact");
        	String companyTelephone = request.getParameter("companyTelephone");
        	String companyEmail = request.getParameter("companyEmail");
        	
        	String bossNom = request.getParameter("bossNom");
        	String bossPrenom = request.getParameter("bossPrenom");
      		String bossEmail = request.getParameter("bossEmail");
      		String bossJob = request.getParameter("bossJob");
        	String bossTelephone = request.getParameter("bossTelephone");
        	String bossFax = request.getParameter("bossFax");
        	
        	String description = request.getParameter("description");
        	String startDate = request.getParameter("startDate");
        	String endDate = request.getParameter("endDate");
        	String salary = request.getParameter("salary");
        	String benefit = request.getParameter("benefit");
        	String healthInsurance = request.getParameter("healthInsurance");
        	String workTrip = request.getParameter("workTrip");
        	String wayFindApply = request.getParameter("wayFindApply");
          %>
          
          <input type="hidden" name="group" value="<%=group%>">
          <input type="hidden" name="nom" value="<%=nom%>">
          <input type="hidden" name="prenom" value="<%=prenom%>">
          <input type="hidden" name="numOfSocialSecurity" value="<%=numOfSocialSecurity%>">
          <input type="hidden" name="parcours" value="<%=parcours%>">
          <input type="hidden" name="personAddress" value="<%=personAddress%>">
          <input type="hidden" name="personEmail" value="<%=personEmail%>">
          <input type="hidden" name="personTelephone" value="<%=personTelephone%>">
          <input type="hidden" name="siretNum" value="<%=siretNum%>">
          <input type="hidden" name="CodeAPE" value="<%=CodeAPE%>">
          <input type="hidden" name="companyName" value="<%=companyName%>">
          <input type="hidden" name="companyAddress" value="<%=companyAddress%>">
          <input type="hidden" name="applyAddress" value="<%=applyAddress%>">
          <input type="hidden" name="receptionName" value="<%=receptionName%>">
          <input type="hidden" name="applyPhone" value="<%=applyPhone%>">
          <input type="hidden" name="companyFax" value="<%=companyFax%>">
          <input type="hidden" name="chargeContact" value="<%=chargeContact%>">
          <input type="hidden" name="companyTelephone" value="<%=companyTelephone%>">
          <input type="hidden" name="companyEmail" value="<%=companyEmail%>">
          <input type="hidden" name="bossNom" value="<%=bossNom%>">
          <input type="hidden" name="bossPrenom" value="<%=bossPrenom%>">
          <input type="hidden" name="bossEmail" value="<%=bossEmail%>">
          <input type="hidden" name="bossJob" value="<%=bossJob%>">
          <input type="hidden" name="bossTelephone" value="<%=bossTelephone%>">
          <input type="hidden" name="bossFax" value="<%=bossFax%>">
          <input type="hidden" name="description" value="<%=description%>">
          <input type="hidden" name="startDate" value="<%=startDate%>">
          <input type="hidden" name="endDate" value="<%=endDate%>">
          <input type="hidden" name="salary" value="<%=salary%>">
          <input type="hidden" name="benefit" value="<%=benefit%>">
          <input type="hidden" name="healthInsurance" value="<%=healthInsurance%>">
          <input type="hidden" name="workTrip" value="<%=workTrip%>">
          <input type="hidden" name="wayFindApply" value="<%=wayFindApply%>">
          
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea" name="prestation"></textarea>
              <label for="icon_prefix2">Présentation succincte de l’Entreprise ou du Service</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea" name="contast"></textarea>
              <label for="icon_prefix2">Contexte dans lequel s’intègre le stage</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea" name="applyGoal"></textarea>
              <label for="icon_prefix2">Mission confiée au stagiaire - Objectifs</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea" name="pricipleSteps"></textarea>
              <label for="icon_prefix2">Si possible, principales étapes du stage</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea" name="applyRequirement"></textarea>
              <label for="icon_prefix2">Connaissances requises</label>
            </div>
          </div>
          <div class="row">
            <div class="col s3 offset-s5">
            <i class="material-icons left">email</i><input class="waves-effect waves-light btn btn-isep" type="submit" name="submit" value="Envoyer">
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
