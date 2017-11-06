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

<title>DASHGUM - Bootstrap Admin Template</title>

<!-- Bootstrap core CSS -->
<link href="<%= request.getContextPath()%>/resources/css/bootstrap.css"
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
	rel="stylesheet">

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
					<i class="fa fa-angle-right"></i> Blank Page
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
													<th>Code postal Secteur</th>
													<th>Numéro de la tournée</th>
													<th>Date d'affectation</th>
													<th>Date de fin d'affectation</th>
													<th>Nature tournée</th>
													<th>Moyen locomotion</th>
													<th>Facteur</th>
													<th>Observation</th>
													<th>Modifier l'affectation</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${affectations}" var="affectation" varStatus="vs">
													<tr>
														<td>${affectation.tournee.secteur.codePostal}</td>
														<td>${affectation.tournee.numTournee}</td>
														<td>${affectation.dateAffectation}</td>
														<td>${affectation.dateFinAffectation}</td>
														<td>${affectation.tournee.typeTournee}</td>
														<td>${affectation.tournee.moyenLocomotion}</td>
														<td>${affectation.facteur.nom}<span>&nbsp;</span>
															${affectation.facteur.prenom}
														</td>
														<td>${affectation.observationAff}</td>
														<td>
															<center>
																<a href="#" class="updatelink" data-toggle="modal"
																	data-target="#modificationaffectation${vs.index}"> <img
																	src="<%=request.getContextPath()%>/resources/img/updateicon.png"
																	class="img-rounded" width="25" />
																</a>
															</center> 
														</td>
													</tr>
													
													
													<!-- Start Modal -->
															<div class="modal fade" id="modificationaffectation${vs.index}"
																role="dialog">
																<div class="modal-dialog modal-lg">
																	<div class="modal-content">
																		<div class="modal-header">
																			<button type="button" class="close"
																				data-dismiss="modal">&times;</button>
																			<h4 class="modal-title"> <center> Affectation : ${affectation.facteur.nom}&nbsp;${affectation.facteur.prenom} _ ${affectation.tournee.secteur.codePostal}-${affectation.tournee.numTournee}</center> </h4>
																		</div>
																		<div class="modal-body">

																			<div class="row mt">
																				<div class="col-lg-12">

																					<form role="form"
																						action="<%=request.getContextPath()%>/affectation/update/"
																						method="post">
																						<div class="col-xs-6 col-md-offset-3">
																							<div class="col-md-12">

																								<div class="form-group">
																										 <label class="control-label">Date d'affectation</label>
																										 <input id="df" name="df" maxlength="100" type="date" required="required" class="form-control" value="${affectation.dateAffectation}" />
																								</div>
																								
																								<div class="form-group">
																										 <label class="control-label">Date de la fin d'affectation</label>
																										 <input id="ff" name="ff" maxlength="100" type="date" class="form-control" value="${affectation.dateFinAffectation}"/>
																								</div>

																								 <div class="form-group">
																									<label class="control-label">Facteur</label> 
																									<input id="facteurName" name="facteurName" maxlength="100" type="text" required="required" class="form-control" value="${affectation.facteur.nom}&nbsp;${affectation.facteur.prenom}" readonly="readonly"/>
																								</div>  
																								<input hidden="hidden" id="idFact"
																									name="idFact" value="${affectation.facteur.idF}" />

																								<div class="form-group">
																									<label class="control-label">Secteur</label>
																									<input id="secteurCp" name="secteurCp" maxlength="100" type="text" required="required" class="form-control" value="${affectation.tournee.secteur.codePostal}" readonly="readonly" /> 
																								</div>

																								<div class="form-group">
																									<label class="control-label">Tournée</label>
																									<input id="tourneeNum" name="tourneeNum" maxlength="100" type="text" required="required" class="form-control" value="${affectation.tournee.numTournee}" readonly="readonly" />
																								</div>

																								<input hidden="hidden" id="idTour"
																									name="idTour" value="${affectation.tournee.idT}" />
																								
																								<input hidden="hidden" id="idAff"
																									name="idAff" value="${affectation.idF}" />	
																									

																								<div class="form-group">
																									<label class="control-label">Observation
																										de l'affectation</label>
																									<textarea id="observationAff"
																										name="observationAff" required="required"
																										class="form-control"
																										placeholder="Entrer l'observation">${affectation.observationAff}</textarea>
																								</div>

																								<button
																									class="btn btn-success btn-lg pull-right"
																									type="submit">Mettre à jour
																								</button>

																							</div>
																						</div>
																					</form>

																				</div>
																			</div>


																		</div>
																		<div class="modal-footer">
																			<button type="button" class="btn btn-default"
																				data-dismiss="modal">Fermer</button>
																		</div>
																	</div>
																</div>
															</div> <!-- End Modal -->
													
													
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
			</section>
			<! --/wrapper -->
		</section>
		<!-- /MAIN CONTENT -->

		<!--main content end-->

		<!--footer start-->
		<%@ include file="/WEB-INF/views/footer/footer.jsp"%>
		<!--footer end-->

	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
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

	<!--common script for all pages-->
	<script
		src="<%=request.getContextPath()%>/resources/js/common-scripts.js"></script>

	<!--script for this page-->

	<script>
	
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
