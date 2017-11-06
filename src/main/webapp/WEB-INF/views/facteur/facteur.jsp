<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>PM - DISTRIBUTION</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet">

<!--external css-->
<link
	href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/style-responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">


<link
	href="maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
	
<link
	href="<%=request.getContextPath()%>/resources/formsteps/css/style.css"
	rel="stylesheet" >

<!-- DataTables CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


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
					<i class="fa fa-angle-right"></i>Facteurs
				</h3>
				<div class="row mt">
					<div class="col-lg-12">
						<div class="row">
							<div class="col-lg-12">
								<div class="panel panel-info">
									<div class="panel-heading">Liste des facteurs</div>
									<!-- /.panel-heading -->
									<div class="panel-body">
										<table width="100%"
											class="table table-striped table-bordered table-hover"
											id="dataTables-example">
											<thead>
												<tr>
													<th>Matricule</th>
													<th>Nom</th>
													<th>Prénom</th>
													<th>Sexe</th>
													<th>Date de naissance</th>
													<th>Date de recrutement</th>
													<th>Observation</th>
													<th>Tournee</th>
													<th>Tenue</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${facteurs}" var="facteur" varStatus="vs">
													<tr class="odd gradeX">
														<td>${facteur.matricule}</td>
														<td>${facteur.nom}</td>
														<td>${facteur.prenom}</td>
														<td>${facteur.sexe}</td>
														<td>${facteur.dateNaissance}</td>
														<td>${facteur.dateRecrutement}</td>
														<td>${facteur.observationFacteur}</td>
														<td><!-- 
															<c:choose>
																<c:when test="${fn:length(facteur.tournees) gt 0}">
																	<c:out value="AFFECTE" />
																</c:when>
																<c:otherwise>
																	<c:out value="NEANT" />
																</c:otherwise>
															</c:choose>
															 -->
															 TEST
														</td>
														<td>
														<c:choose>
																<c:when test="${facteur.tenue==null}">
																	<c:out value="SANS TENUE" />
																</c:when>
																<c:otherwise>
																	<div align="center">
																		<a href="" data-toggle="modal" data-target="#mesureTenueModal${vs.index}">
																			<img
																			src="<%=request.getContextPath()%>/resources/img/viewdetails.png"
																			alt="Voir détails" class="img-rounded" width="25" />
																		</a>
																	</div>
																	<!-- Start Modal -->
																	<div class="modal fade" id="mesureTenueModal${vs.index}" role="dialog">
																		<div class="modal-dialog modal-sm">
																			<div class="modal-content">
																				<div class="modal-header">
																					<button type="button" class="close"
																						data-dismiss="modal">&times;</button>
																					<h4 class="modal-title">Facteur :
																						${facteur.nom} &nbsp; ${facteur.prenom}</h4>
																				</div>
																				<div class="modal-body">
																					<p style="align:center;">Mesures de la tenue</p>
																					<h6>Type de la tenue :
																						${facteur.tenue.typeTenue}</h6>
																					<h6>Taille de la veste :
																						${facteur.tenue.tailleVeste}</h6>
																					<h6>Taille du pontalon :
																						${facteur.tenue.taillePantalon}</h6>
																					<h6>Taille de la chemise MC :
																						${facteur.tenue.tailleChemiseMC}</h6>
																					<h6>Taille de la chemise ML :
																						${facteur.tenue.tailleChemiseML}</h6>
																					<h6>Taille du gilet :
																						${facteur.tenue.tailleGilet}</h6>
																					<h6>Taille du parka :
																						${facteur.tenue.tailleParka}</h6>
																					<h6>Taille de la casquette :
																						${facteur.tenue.tailleCasquette}</h6>
																					<h6>Taille pull over :
																						${facteur.tenue.taillePullOver}</h6>
																					<h6>Observation :
																						${facteur.tenue.observationTenue}</h6>
																				</div>
																				<div class="modal-footer">
																					<button type="button" class="btn btn-default"
																						data-dismiss="modal">Fermer</button>
																				</div>
																			</div>
																		</div>
																	</div>
																	<!-- End Modal -->
																</c:otherwise>
															</c:choose>
															</td>
														<td>
															<div align="center">
																<a href="#" class="deletelink" data-facteur-id="${facteur.idF}" > 
																	<img 
																	src="<%=request.getContextPath()%>/resources/img/deleteicon.png"
																	class="img-rounded" width="25" />
																</a> 
																&nbsp;
																<a href="#"  class="updatelink" data-toggle="modal" data-target="#um${vs.index}">
																	<img
																	src="<%=request.getContextPath()%>/resources/img/updateicon.png"
																	class="img-rounded" width="25" />
																</a>
															</div>								
														</td>
													</tr>
													
		<!-- Start Modal -->
			<div class="modal fade" id="um${vs.index}" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 id="modaltitle" class="modal-title">Mise à jour  : ${facteur.nom} &nbsp; ${facteur.prenom}</h4>
						</div>
						<div class="modal-body">

							<div class="stepwizard col-md-offset-3">
								<div class="stepwizard-row setup-panel">
									<div class="stepwizard-step">
										<a href="#step-1${vs.index}" type="button"
											class="btn btn-primary btn-circle">1</a>
										<p>Informations personnelles</p>
									</div>
									<div class="stepwizard-step">
										<a href="#step-2${vs.index}" type="button"
											class="btn btn-default btn-circle">2</a>
										<p>Mesures de la tenue</p>
									</div>
								</div>
							</div>

							<form role="form" action="<%=request.getContextPath()%>/facteur/modifier/${facteur.idF}" method="post">
								<div class="row setup-content" id="step-1${vs.index}">
									<div class="col-xs-6 col-md-offset-3">
										<div class="col-md-12">
											<h3>Informations personnelles</h3>
											<div class="form-group">
												<label class="control-label">Matricule</label> 
												<input
													id=matricule name="matricule" maxlength="100" type="number"
													required="required" class="form-control"
													placeholder="Entrer le matricule" value="${facteur.matricule}"/>
											</div>
											<div class="form-group">
												<label class="control-label">Nom</label> 
												<input id="nom" name="nom"
													maxlength="100" type="text" required="required"
													class="form-control" placeholder="Entrer le nom" value="${facteur.nom}" />
											</div>
											<div class="form-group">
												<label class="control-label">Prénom</label> 
												<input
													id="prenom" name="prenom" maxlength="100" type="text" required="required"
													class="form-control" placeholder="Entrer le prénom" value="${facteur.prenom}" />
											</div>
											<div class="form-group">
												<label class="control-label">Sexe</label> 
												<select id="sexe"
													name="sexe" required="required" class="form-control">
													<option disabled="disabled">Choisir le sexe</option>
													<c:if test="${facteur.sexe == 'M'}">
															<option selected="selected"  >M</option>
															<option>F</option>														
													</c:if>	
													<c:if test="${facteur.sexe == 'F'}">
															<option>M</option>
															<option selected="selected" >F</option>														
													</c:if>
												</select>
											</div>
											<div class="form-group">
												<label class="control-label">Date de naissance</label> 
												<input
													id="dateNaissance" name="dateNaissance" maxlength="100"
													type="date" required="required" class="form-control"
													placeholder="Entrer la date de naissance" value="${facteur.dateNaissance}"/>
											</div>
											<div class="form-group">
												<label class="control-label">Date de recrutement</label> 
												<input
													id="dateRecrutement" name="dateRecrutement" maxlength="100"
													type="date" required="required" class="form-control"
													placeholder="Entrer la date de recrutement" value="${facteur.dateRecrutement}" />
											</div>
											<div class="form-group">
												<label class="control-label">Observation du facteur</label>
												<textarea id="observationFacteur" name="observationFacteur"
													required="required" class="form-control"
													placeholder="Entrer l'observation">${facteur.observationFacteur}</textarea>
											</div>
											<button class="btn btn-primary nextBtn btn-lg pull-right"
												type="button">Suivant</button>
										</div>
									</div>
								</div>
								<div class="row setup-content" id="step-2${vs.index}">
									<div class="col-xs-6 col-md-offset-3">
										<div class="col-md-12">
											<h3>Mesures de la tenue</h3>

											<div class="form-group">
												<label class="control-label">Type de la tenue</label> 
												<select id="typeTenue" name="typeTenue" required="required" class="form-control">
												<c:if test="${facteur.tenue==null}">
													<option selected="selected" disabled="disabled">Selectionner le type de la tenue</option>
													<option value="Courrier">Courrier</option>
													<option value="Messagerie">Messagerie</option>
												</c:if>
												<c:if test="${facteur.tenue.typeTenue=='Courrier'}">
													<option disabled="disabled">Selectionner le type de la tenue</option>
													<option selected="selected" value="Courrier">Courrier</option>
													<option value="Messagerie">Messagerie</option>
												</c:if>
												<c:if test="${facteur.tenue.typeTenue=='Messagerie'}">
													<option disabled="disabled">Selectionner le type de la tenue</option>
													<option value="Courrier">Courrier</option>
													<option selected="selected" value="Messagerie">Messagerie</option>
												</c:if>
												</select>
											</div>

											<div class="form-group">
												<label class="control-label">Taille de la veste</label> 
												<input
													id="tailleVeste" name="tailleVeste" maxlength="200"
													type="number" required="required" class="form-control"
													placeholder="Saisir la taille de la veste" value="${facteur.tenue.tailleVeste}" />
											</div>

											<div class="form-group">
												<label class="control-label">Taille du pantalon</label> <input
													id="taillePantalon" name="taillePantalon" maxlength="200"
													type="number" required="required" class="form-control"
													placeholder="Saisir la taille du pantalon" value="${facteur.tenue.taillePantalon}" />
											</div>

											<div class="form-group">
												<label class="control-label">Taille de la chemise MC</label>
												<input id="tailleChemiseMC" name="tailleChemiseMC"
													maxlength="200" type="number" required="required"
													class="form-control"
													placeholder="Saisir la taille de la chemise MC" value="${facteur.tenue.tailleChemiseMC}" />
											</div>

											<div class="form-group">
												<label class="control-label">Taille de la chemise ML</label>
												<input id="tailleChemiseML" name="tailleChemiseML"
													maxlength="200" type="number" required="required"
													class="form-control"
													placeholder="Saisir la taille de la chemise ML" value="${facteur.tenue.tailleChemiseML}" />
											</div>

											<div class="form-group">
												<label class="control-label">Taille du gilet</label> 
												<select
													id="tailleGilet" name="tailleGilet" class="form-control">
													<c:if test="${facteur.tenue==null}">
														<option selected="selected" disabled="disabled">Selectionner la taille du gilet</option>
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='M'}">
														<option selected="selected">M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='S'}">
														<option>M</option>
														<option selected="selected">S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='L'}">
														<option>M</option>
														<option>S</option>
														<option selected="selected">L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='XL'}">
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option selected="selected">XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='XXL'}">
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option selected="selected">XXL</option>
													</c:if>
												</select>
											</div>

											<div class="form-group">
												<label class="control-label">Taille du parka</label> 
												<select
													id="tailleParka" name="tailleParka" class="form-control">
													<c:if test="${facteur.tenue==null}">
														<option selected="selected" disabled="disabled">Selectionner la taille du parka</option>
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='M'}">
														<option selected="selected">M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='S'}">
														<option>M</option>
														<option selected="selected">S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='L'}">
														<option>M</option>
														<option>S</option>
														<option selected="selected">L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='XL'}">
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option selected="selected">XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='XXL'}">
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option selected="selected">XXL</option>
													</c:if>
												</select>
											</div>

											<div class="form-group">
												<label class="control-label">Taille du cardigan</label> 
												<select
													id="tailleCardigan" name="tailleCardigan"
													class="form-control">
													<c:if test="${facteur.tenue==null}">
														<option selected="selected" disabled="disabled">Selectionner la taille du cardigan</option>
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='M'}">
														<option selected="selected">M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='S'}">
														<option>M</option>
														<option selected="selected">S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='L'}">
														<option>M</option>
														<option>S</option>
														<option selected="selected">L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='XL'}">
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option selected="selected">XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='XXL'}">
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option selected="selected">XXL</option>
													</c:if>
												</select>
											</div>

											<div class="form-group">
												<label class="control-label">Taille pull over</label> <select
													id="taillePullOver" name="taillePullOver"
													class="form-control">
													<c:if test="${facteur.tenue==null}">
														<option selected="selected" disabled="disabled">Selectionner la taille du pull over</option>
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='M'}">
														<option selected="selected">M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='S'}">
														<option>M</option>
														<option selected="selected">S</option>
														<option>L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='L'}">
														<option>M</option>
														<option>S</option>
														<option selected="selected">L</option>
														<option>XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='XL'}">
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option selected="selected">XL</option>
														<option>XXL</option>
													</c:if>
													<c:if test="${facteur.tenue.tailleGilet=='XXL'}">
														<option>M</option>
														<option>S</option>
														<option>L</option>
														<option>XL</option>
														<option selected="selected">XXL</option>
													</c:if>
												</select>
											</div>

											<div class="form-group">
												<label class="control-label">Taille de la casquette</label> 
													<input id="tailleCasquette" name="tailleCasquette"
													maxlength="200" type="number" required="required"
													class="form-control"
													placeholder="Saisir la taille de la casquette" value="${facteur.tenue.tailleCasquette}" />
											</div>

											<div class="form-group">
												<label class="control-label">Observation de la tenue</label>
												<textarea id="observationTenue" name="observationTenue"
													required="required" class="form-control"
													placeholder="Entrer l'observation">${facteur.tenue.observationTenue}</textarea>
											</div>

											<button class="btn btn-success btn-lg pull-right"
												type="submit">Enregistrer</button>
										</div>
									</div>
								</div>
							</form>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Fermer</button>
						</div>
					</div>
				</div>
			</div>
			<!-- End Modal -->
	
																												
												</c:forEach>
											</tbody>
										</table>
										<!-- /.table-responsive -->
									</div>
									<!-- /.panel-body -->
								</div>
								<!-- /.panel -->
							</div>
							<!-- /.col-lg-12 -->
						</div>
					</div>
				</div>
			</section>
			
			<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">Confirmation de la suppression</div>
						<div class="modal-body">Voulez-vous vraiment supprimer ce facteur ?</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
							<a id="del" class="btn btn-danger btn-ok">Supprimer</a>
						</div>
					</div>
				</div>
			</div>
				
		</section>
		<!-- /MAIN CONTENT -->

		<!--main content end-->
		
		<!--footer start-->
	   			<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
	    <!--footer end-->
		
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	
	<script>
	
	$(document).ready(function() {
		$(".deletelink").click(function() {
				var facteurId = $(this).data("facteur-id");
				$('#confirm-delete').modal('show');
				$('#del').attr("href","supprimer/"+facteurId);
		});
	});
	
	</script>
	
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.ui.touch-punch.min.js"></script>
	<script class="include" type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.scrollTo.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.nicescroll.js"
		type="text/javascript"></script>


	<!--common script for all pages-->
	<script
		src="<%=request.getContextPath()%>/resources/js/common-scripts.js"></script>

	<script src="code.jquery.com/jquery-1.10.2.min.js"></script>

	<script
		src="maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/formsteps/js/script.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!--script for this page-->
	<script type="text/javascript">
		
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});

		//custom select box

		$(function() {
			$('select.styled').customSelect();
		});
		
	</script>

</body>
</html>
