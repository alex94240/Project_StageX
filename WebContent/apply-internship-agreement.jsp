<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Stage X - Demande de convention de stage</title>
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
      <div class="row">
        <div class="col s1">
          <!-- Modal Trigger -->
          <a class="modal-trigger waves-effect waves-light btn-floating btn-large btn-isep" href="#modal1"><i class="material-icons left">info</i></a>
        </div>
        <div class="col s6 offset-s5">
          <a class="waves-effect waves-light btn btn-isep" href="validate-apply.jsp"><i class="material-icons left">email</i>Valider les demandes<span class="new badge red">4</span></a>
        </div>
      </div>
      <!-- Modal Structure -->
      <div id="modal1" class="modal">
        <div class="modal-content">
          <h4>Informations</h4>
          <p>
            Ce formulaire permet le suivi administratif et pédagogique de votre stage
            Il doit être impérativement rempli par l'élève avec l'aide de l'entreprise, et remis au Bureau des Stages au plus tard 15 jours avant le début du stage, dans tous les cas (convention ou autre contrat)
          </p>
          <p>
            Les stages font l'objet d'une autorisation de l'ISEP devant être impérativement obtenue avant le début du stage (case « visa ISEP » ci-dessous)
          </p>
          <p>
            Si des modifications interviennent dans le contenu du présent formulaire, le bureau des stages devra en être aussitôt informé.
          </p>
          <hr>
          <h4>Nota 1</h4>
          <p>
            <strong>Visa ISEP :</strong>
            <ul>
              <li>Pour les stages du cycle ingénieur, la déclaration doit être visée par le responsable parcours</li>
              <li>Pour les stages des étudiants en MSc, la déclaration doit être visée par le responsable de majeur dont dépend le stagiaire et par le Directeur des Relations Internationales si le stage se déroule à l'étranger.</li>
            </ul>
          </p>
          <hr>
          <h4>Nota 2</h4>
          <p>
            <strong>Stage à l'étranger : indemnité et assurance :</strong><br><br>
 	 		L'élève doit demander à l'Entreprise si, au vu du droit du travail local et des conditions du stage (durée, montant de l'indemnité, caractère obligatoire, etc.), elle assure la couverture en matière de risques Maladie et Accidents du travail (Health and Industrial injury insurance). 
            <ul>
              <li>Si l'entreprise assure cette couverture, une attestation devra lui être demandée par l'élève.</li>
              <li>Si cette couverture n'est pas assurée par l'entreprise, deux cas se présentent :</li>
              <ul>
                <li>l'indemnité de stage est inférieure ou égale à 15 % du plafond mensuel de la sécurité sociale, le stagiaire est assuré par la Division des Régimes Spéciaux.</li>
                <li>dans le cas contraire, il devra prendre une assurance accident personnelle et fournir une attestation en même temps que la D.S..
 				La CFE (Caisse des Français à l'Etranger) propose une assurance garantissant le versement d'indemniés journalères en cas d'incapacié liée à un accident du travail (Cf. portail élèves, rubrique « stages », paragraphe 9 « stages à l'étranger, accident du travail - risques professionnels).</li>
              </ul>
            </ul>
			Dans tous les cas, une attestation d'assurance complémentaire couvrant au minimum soins médicaux et pharmaceutiques, soins dentaires, hospitalisation et rapatriement devra être fournie par l'élève en même temps que la D.S.          </p>
          <hr>
          <h4>Nota 3</h4>
          	<p>
            <strong> Déplacement à l'étranger durant le stage en France </strong>
            <ul>
              <li>Dans le cas où l'indemnité de stage perçue est inférieure ou égale à 15 % du plafond mensuel de la sécurité sociale</li>
              <li>Tout déplacement à l'étranger doit être signalé le plus tôt possible à l'ISEP ; l'accord de la Sécurité Sociale doit être obtenu avant le déplacement</li>
            </ul>
			Si le déplacement s'effectue dans un pays de l'UE/EEE, les élèves ressortissants d'un pays de l'UE/EEE doivent demander la Carte Européenne d'Assurance Maladie.           </p>
        	</p>
        </div>
        <div class="modal-footer">
          <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Fermer</a>
        </div>
      </div>
      
      <div class="row card-panel">
        <form class="col s12" action="supplementary-apply.jsp">
          <div class="row">
            <div class="input-field col s2">
              <p>
                <input class="with-gap" name="group" type="radio" id="test1"/>
                <label for="test1">A2</label>
              </p>
            </div>
            <div class="input-field col s2">
              <p>
                <input class="with-gap" name="group" type="radio" id="test2"/>
                <label for="test2">A3</label>
              </p>
            </div>
            <div class="input-field col s2">
              <p>
                <input class="with-gap" name="group" type="radio" id="test3"/>
                <label for="test3">Césure</label>
              </p>
            </div>
            <div class="input-field col s2">
              <p>
                <input class="with-gap" name="group" type="radio" id="test4"/>
                <label for="test4">Msc</label>
              </p>
            </div>
          </div><br>
          <hr>
          <div class="row">
            <div class="col s2">
              <h5>Elève</h5>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">perm_identity</i>
              <input id="icon_prefix" type="text" class="validate" name="nom">
              <label for="icon_prefix">Nom</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">account_circle</i>
              <input id="icon_prefix" type="text" class="validate" name="prenom">
              <label for="icon_prefix">Prénom</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">dialpad</i>
              <input id="icon_prefix" type="text" class="validate" name="numOfSocialSecurity">
              <label for="icon_prefix">Numéro de sécurité sociale</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="parcours">
              <label for="icon_prefix">Parcours</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">play_for_work</i>
              <input id="icon_prefix" type="text" class="validate" name="personAddress">
              <label for="icon_prefix">Adresse durant le stage</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">email</i>
              <input id="icon_prefix" type="text" class="validate" name="personEmail">
              <label for="icon_prefix">Adresse email</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">contact_phone</i>
              <input id="icon_prefix" type="text" class="validate" name="personTelephone">
              <label for="icon_prefix">Téléphone portable</label>
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="s2">
              <h5>Entreprise</h5>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="siretNum">
              <label for="icon_prefix">Numéro SIRET de l'Entreprise</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="CodeAPE">
              <label for="icon_prefix">Code APE</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="companyName">
              <label for="icon_prefix">Nom de la société signataire de la convention ou du contrat</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="companyAddress">
              <label for="icon_prefix">Adresse de la société signataire de la convention ou du contrat</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="applyAddress">
              <label for="icon_prefix">Adresse complète du lieu du stage (si différente de l'adresse précédante)</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="receptionName">
              <label for="icon_prefix">Nom du service d'accueil dans la société</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="applyPhone">
              <label for="icon_prefix">Standard Téléphonique du lieu du stage</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="companyFax">
              <label for="icon_prefix">N° de FAX</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="chargeContact">
              <label for="icon_prefix">Nom et prénom adresse de la personne à qui il faut adresser la convention de stage le cas échéant</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="companyTelephone">
              <label for="icon_prefix">N° de Tél.</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="companyEmail">
              <label for="icon_prefix">Adresse E-Mail</label>
            </div>
          </div>
          <div class="row">
            <div class="col s4">
              <h6>Responsable de stage</h6>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="bossNom">
              <label for="icon_prefix">Nom</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="bossPrenom">
              <label for="icon_prefix">Prénom</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="bossEmail">
              <label for="icon_prefix">Adresse e-mail</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="bossJob">
              <label for="icon_prefix">Fonction précise dans la société</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="bossTelephone">
              <label for="icon_prefix">N° de Tél.</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="bossFax">
              <label for="icon_prefix">N° de FAX</label>
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="s2">
              <h5>Stage</h5>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea" name="description"></textarea>
              <label for="icon_prefix2">Thème du stage</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s5 offset-s1">
              <label for="birthdate" class="active">Dates prévues pour le stage du</label>
              <input type="date" class="datepicker" name="startDate">
            </div>
            <div class="input-field col s5">
              <label for="birthdate" class="active">Au</label>
              <input type="date" class="datepicker" name="endDate">
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="salary">
              <label for="icon_prefix">Indemnité de stage (en euros, mensuelle brute)</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">skip_next</i>
              <input id="icon_prefix" type="text" class="validate" name="benefit">
              <label for="icon_prefix">Avantages en nature (en euros)</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s11 offset-s1">
              <label for="icon_prefix">A l'étranger<sup>2</sup>, Si l'indemnité est supérieure à 15 % du plafond mensuel de la sécurité sociale (cad supérieure à 554,40 €), la société s'engage-t-elle à assurer la couverture des risques Maladie et Accident du travail</label><br><br>
              <div class="row">
                <div class="col s1">
                  <input class="with-gap" name="healthInsurance" type="radio" id="Oui"/>
                  <label for="Oui">Oui</label>
                </div>
                <div class="col s1">
                  <input class="with-gap" name="healthInsurance" type="radio" id="Non"/>
                  <label for="Non">Non</label>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s11 offset-s1">
              <label for="icon_prefix">Déplacement à l'étranger<sup>3</sup> au cours du stage (effectué en France)</label><br>
              <div class="row">
                <div class="col s1">
                  <input class="with-gap" name="workTrip" type="radio" id="Hello"/>
                  <label for="Hello">Oui</label>
                </div>
                <div class="col s1">
                  <input class="with-gap" name="workTrip" type="radio" id="Bye"/>
                  <label for="Bye">Non</label>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">mode_edit</i>
              <textarea id="icon_prefix2" class="materialize-textarea" name="wayFindApply"></textarea>
              <label for="icon_prefix2">Par quel moyen vous avez trouvé ce stage</label>
            </div>
          </div>
          <div class="row">
            <div class="col s9 offset-s3">
              <p>
                <input type="checkbox" class="filled-in" id="filled-in-box"/>
                <label for="filled-in-box">J'atteste sur l'honneur l'exactitude des renseignements ci-dessus</label>
              </p>
            </div>
          </div>
          <div class="row">
            <div class="col s3 offset-s5">
              <input class="waves-effect waves-light btn btn-isep" type="submit" name="submit" value="Suivant">
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
  $('.datepicker').pickadate({
  selectMonths: true, // Creates a dropdown to control month
  selectYears: 15 // Creates a dropdown of 15 years to control year
  });
  </script>
  <script type="text/javascript">
  $(document).ready(function(){
  // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
  $('.modal').modal();
  });
  </script>

</body>
</html>
