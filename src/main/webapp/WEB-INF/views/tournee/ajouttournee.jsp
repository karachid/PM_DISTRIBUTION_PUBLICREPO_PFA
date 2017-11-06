<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/resources/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="<%=request.getContextPath() %>/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/style-responsive.css" rel="stylesheet">
    
    <link href="maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link href="<%=request.getContextPath()%>/resources/formsteps/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <%@ include file="/WEB-INF/views/menu_top/topmenu.jsp" %>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
       <%@ include file="/WEB-INF/views/menu_left/leftmenu.jsp" %>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper site-min-height">
				<h3>
					<i class="fa fa-angle-right"></i> Nouvelle tournée
				</h3>
				<div class="row mt">
				
			 	<div class="col-md-12">
				<c:if test="${! empty successmsg}">
		        		<div class="alert alert-success">
  								<strong>Opération réussie !</strong> ${successmsg}
						</div>
		        </c:if>
		        <c:if test="${! empty errormsg}">
		        		<div class="alert alert-danger">
  								<strong>Erreur !</strong> ${errormsg}
						</div>
		        </c:if>
				</div>  
				
          
          	<div class="stepwizard col-md-offset-3">
					<div class="stepwizard-row setup-panel">
						<div class="stepwizard-step">
							<a href="#step-1" type="button"
								class="btn btn-primary btn-circle">1</a>
							<p>Informations générales</p>
						</div>
						<div class="stepwizard-step">
							<a href="#step-2" type="button"
								class="btn btn-default btn-circle" disabled="disabled">2</a>
							<p>Détails de la tournée</p>
						</div>
					</div>
				</div>

				<form role="form" action="<%=request.getContextPath() %>/tournee/ajouttournee/" method="post">
					<div class="row setup-content" id="step-1">
						<div class="col-xs-6 col-md-offset-3">
							<div class="col-md-12">
								<h3>Informations générales</h3>
								<div class="form-group">
									<label class="control-label">Numéro de la tournée</label> 
									<input id="numTournee" name="numTournee" maxlength="100" type="number" required="required" class="form-control" placeholder="Entrer le numéro de la tournée" />
								</div>
								<div class="form-group">
									<label class="control-label">Code postal du secteur</label> 
										<select id="codepostal" name="codepostal" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le code postal</option>
											<c:forEach items="${secteurs}" var="secteur">
												<option>${secteur.codePostal}</option>
											</c:forEach>
										</select>
								</div>
								<div class="form-group">
									<label class="control-label">Date de création de la tournée</label> 
									<input id="dateCreationTournee" name="dateCreationTournee" maxlength="100" type="date" required="required" class="form-control" />
								</div>
								
								
								<div class="form-group">
									<label class="control-label">Nature de la tournée</label> 
										<select id="natureTournee" name="natureTournee" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir la nature de la tournée</option>
											<option>MIXTE</option>
											<option>COURRIER</option>
											<option>MESSAGERIE</option>
										</select>
								</div>
								
								
								<div class="form-group">
									<label class="control-label">Statut de la tournée</label> 
										<select id="statutTournee" name="statutTournee" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le statut de la tournée</option>
											<option>A</option>
											<option>NA</option>
										</select>
								</div>
								
								
								<div class="form-group">
									<label class="control-label">Type de la tournée</label> 
										<select id="typeTournee" name="typeTournee" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le type de la tournée</option>
											<option>M</option>
											<option>P</option>
										</select>
								</div>
								
								
								<div class="form-group">
									<label class="control-label">Type de la zone</label> 
										<select id="typeZone" name="typeZone" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le type de la zone</option>
											<option>U</option>
											<option>R</option>
										</select>
								</div>
								
								
								<div class="form-group">
									<label class="control-label">Date de mise à jour de la tournée</label> 
									<input id="dateMaj" name="dateMaj" maxlength="100" type="date" required="required" class="form-control" />
								</div>
								
								
								
								<div class="form-group">
									<label class="control-label">Type d'habitat dominant</label> 
										<select multiple="multiple" id="typeHabitatDominant" name="typeHabitatDominant" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le type d'habitat dominant</option>
											<option>RESIDENTIEL</option>
											<option>VILLAS</option>
											<option>IMMEUBLES</option>
											<option>INDUSTRIEL</option>
											<option>R+2</option>
											<option>R+3</option>
											<option>R+4</option>
										</select>
								</div>
								
								
								<div class="form-group">
									<label class="control-label">Moyen locomotion</label> 
										<select id="typeMoyenLocomotion" name="typeMoyenLocomotion" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le moyen de locomotion</option>
											<option>CYCLOMOTEUR</option>
											<option>SCOOTER</option>
											<option>VELO</option>
											<option>VEHICULE</option>
										</select>
								</div>
								<button class="btn btn-primary nextBtn btn-lg pull-right" type="button">Suivant</button>
							</div>
						</div>
					</div>
					<div class="row setup-content" id="step-2">
						<div class="col-xs-6 col-md-offset-3">
							<div class="col-md-12">
								<h3>Détails</h3>
								<br>
								<div class="form-group">
									<label class="control-label">Trajet total</label> 
									<input id="trajetTotal" name="trajetTotal" maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la valeur du trajet total" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Montant mensuel de l'indémnité en KM</label> 
									<input id="montantMensuelIndemniteKm" name="montantMensuelIndemniteKm" maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir le montant mensuel de l'indémnité en KM" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Fréquence de distribution hebdomadaire</label> 
									<input id="frequenceDistributionHebdomadaire" name="frequenceDistributionHebdomadaire" maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la fréquence de distribution hebdomadaire" min="1" max="5"/>
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Fréquence de distribution par jour</label> 
									<input id="frequenceDistributionJour" name="frequenceDistributionJour" maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la fréquence de distribution par jour" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Capacité de distribution PIC</label> 
									<input id="capaciteDistributionPIC" name="capaciteDistributionPIC" maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la capacité de distribution PIC" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Capacité de distribution hors PIC</label> 
									<input id="capaciteDistributionHorsPIC" name="capaciteDistributionHorsPIC" maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la capacité de distribution hors PIC" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Observation de la tournée</label>
									<textarea id="observationTournee" name="observationTournee" required="required" class="form-control" placeholder="Entrer l'observation"></textarea>
								</div>
								<br>
								<button class="btn btn-success btn-lg pull-right" type="submit">Enregistrer</button>
							</div>
						</div>
					</div>
				</form>
          </div>
          
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      
      <!--footer start-->
	   <%@ include file="/WEB-INF/views/footer/footer.jsp" %>
	  <!--footer end-->
      
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.ui.touch-punch.min.js"></script>
    <script class="include" type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.scrollTo.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>


    <!--common script for all pages-->
    <script src="<%=request.getContextPath() %>/resources/js/common-scripts.js"></script>
    
    <script src="<%=request.getContextPath()%>/resources/formsteps/js/script.js"></script>

    <!--script for this page-->
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>
