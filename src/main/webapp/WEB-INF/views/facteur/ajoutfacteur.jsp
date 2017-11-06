<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>DASHGUM - Bootstrap Admin Template</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/style-responsive.css" rel="stylesheet">

<link href="maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="<%=request.getContextPath()%>/resources/formsteps/css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
		<%@ include file="/WEB-INF/views/menu_top/topmenu.jsp"%>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<%@ include file="/WEB-INF/views/menu_left/leftmenu.jsp"%>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<h3>
					<i class="fa fa-angle-right"></i> Nouveau Facteur
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
							<p>Informations personnelles</p>
						</div>
						<div class="stepwizard-step">
							<a href="#step-2" type="button"
								class="btn btn-default btn-circle" disabled="disabled">2</a>
							<p>Mesures de la tenue</p>
						</div>
					</div>
				</div>

				<form role="form" action="<%=request.getContextPath() %>/facteur/ajoutfacteur/" method="post">
					<div class="row setup-content" id="step-1">
						<div class="col-xs-6 col-md-offset-3">
							<div class="col-md-12">
								<h3>Informations personnelles</h3>
								<div class="form-group">
									<label class="control-label">Matricule</label> 
									<input id=matricule name="matricule" maxlength="100" type="number" required="required" class="form-control" placeholder="Entrer le matricule" />
								</div>
								<div class="form-group">
									<label class="control-label">Nom</label> 
									<input id="nom" name="nom" maxlength="100" type="text" required="required" class="form-control" placeholder="Entrer le nom" />
								</div>
								<div class="form-group">
									<label class="control-label">Prénom</label> 
									<input id="prenom" name="prenom" maxlength="100" type="text" required="required" class="form-control" placeholder="Entrer le prénom" />
								</div>
								<div class="form-group">
									<label class="control-label">Sexe</label> 
										<select id="sexe" name="sexe" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le sexe</option>
											<option>M</option>
											<option>F</option>
									</select>
								</div>
								<div class="form-group">
									<label class="control-label">Date de naissance</label> 
									<input id="dateNaissance" name="dateNaissance" maxlength="100" type="date" required="required" class="form-control" />
								</div>
								<div class="form-group">
									<label class="control-label">Date de recrutement</label>
									 <input id="dateRecrutement" name="dateRecrutement" maxlength="100" type="date" required="required" class="form-control" />
								</div>
								<div class="form-group">
									<label class="control-label">Observation du facteur</label>
									<textarea id="observationFacteur" name="observationFacteur" required="required" class="form-control" placeholder="Entrer l'observation"></textarea>
								</div>
								<button class="btn btn-primary nextBtn btn-lg pull-right" type="button">Suivant</button>
							</div>
						</div>
					</div>
					<div class="row setup-content" id="step-2">
						<div class="col-xs-6 col-md-offset-3">
							<div class="col-md-12">
								<h3>Mesures de la tenue</h3>
								
								<div class="form-group">
									<label class="control-label">Type de la tenue</label>
									<select id="typeTenue" name="typeTenue" class="form-control">
											<option selected="selected" disabled="disabled">Selectionner le type de la tenue</option>
											<option>Courrier</option>
											<option>Messagerie</option>
									</select>
								</div>
								
								<div class="form-group">
									<label class="control-label">Taille de la veste</label> 
									<input id="tailleVeste" name="tailleVeste" maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la taille de la veste" />
								</div>
								
								<div class="form-group">
									<label class="control-label">Taille du pantalon</label> 
									<input id="taillePantalon" name="taillePantalon" maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la taille du pantalon" />
								</div>
								
								<div class="form-group">
									<label class="control-label">Taille de la chemise MC</label>
									 <input id="tailleChemiseMC" name="tailleChemiseMC" maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la taille de la chemise MC" />
								</div>
								
								<div class="form-group">
									<label class="control-label">Taille de la chemise ML</label> 
									<input id="tailleChemiseML" name="tailleChemiseML"  maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la taille de la chemise ML" />
								</div>
								
								<div class="form-group">
									<label class="control-label">Taille du gilet</label> 
									<select id="tailleGilet" name="tailleGilet" class="form-control">
										<option selected="selected" disabled="disabled">Selectionner la taille du gilet</option>
										<option>M</option>
										<option>S</option>
										<option>L</option>
										<option>XL</option>
										<option>XXL</option>
									</select>
								</div>
								
								<div class="form-group">
									<label class="control-label">Taille du parka</label> 
									<select id="tailleParka" name="tailleParka" class="form-control">
										<option selected="selected" disabled="disabled">Selectionner la taille du parka</option>
										<option>M</option>
										<option>S</option>
										<option>L</option>
										<option>XL</option>
										<option>XXL</option>
									</select>
								</div>
								
								<div class="form-group">
									<label class="control-label">Taille du cardigan</label> 
									<select id="tailleCardigan" name="tailleCardigan" class="form-control">
										<option selected="selected" disabled="disabled">Selectionner la taille du cardigan</option>
										<option>M</option>
										<option>S</option>
										<option>L</option>
										<option>XL</option>
										<option>XXL</option>
									</select>
								</div>
								
								<div class="form-group">
									<label class="control-label">Taille pull over</label> 
									<select id="taillePullOver" name="taillePullOver" class="form-control">
										<option selected="selected" disabled="disabled">Selectionner la taille du pull over</option>
										<option>M</option>
										<option>S</option>
										<option>L</option>
										<option>XL</option>
										<option>XXL</option>
									</select>
								</div>
								
								<div class="form-group">
									<label id="tailleCasquette" name="tailleCasquette" class="control-label">Taille de la casquette</label> 
									<input maxlength="200" type="number" required="required" class="form-control" placeholder="Saisir la taille de la casquette" />
								</div>
								
								<div class="form-group">
									<label class="control-label">Observation de la tenue</label>
									<textarea id="observationTenue" name="observationTenue" required="required" class="form-control" placeholder="Entrer l'observation"></textarea>
								</div>
								
								<button class="btn btn-success btn-lg pull-right" type="submit">Enregistrer</button>
							</div>
						</div>
					</div>
				</form>
				</div>
			</section>
			<! --/wrapper -->
		</section>
		<!-- /MAIN CONTENT -->

		<!--main content end-->

		<!--footer start-->
	   		<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
	    <!--footer end-->

	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.ui.touch-punch.min.js"></script>
	<script class="include" type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.scrollTo.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>


	<!--common script for all pages-->
	<script src="<%=request.getContextPath()%>/resources/js/common-scripts.js"></script>

	<script src="<%=request.getContextPath()%>/resources/formsteps/js/script.js"></script>

	<!--script for this page-->

	<script>
		//custom select box

		$(function() {
			$('select.styled').customSelect();
		});
	</script>

</body>
</html>
