<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Tournees</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/resources/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="<%=request.getContextPath() %>/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/style-responsive.css" rel="stylesheet">
    
    
      <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/dist/css/sb-admin-2.css" rel="stylesheet">
    
    
    <!-- DataTables CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    
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
          	<h3><i class="fa fa-angle-right"></i>Tournees</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
				<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            Liste des tournées
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Numéro tournée</th>
                                        <th>Code postal du secteur</th>
                                        <th>Date de création de tournée</th>
                                        <th>Nature tournée</th>
                                        <th>Statut tournée</th>
                                        <th>Type tournée</th>
                                        <th>Type zone</th>
                                        <th>Date de mise à jour</th>
                                        <th>Type d'habitat dominant</th>
                                        <th>Moyen locomotion</th>
                                        <th>Détails</th>
                                        <th>Action</th>
                                       <!--  <th>Moyen locomotion</th>
                                        <th>Montant mensuel de l'indémnité en KM</th>
                                        <th>Fréquence de distribution hebdomadaire</th>
                                        <th>Fréquence de distribution par jour</th>
                                        <th>Capacité de distribution PIC</th>
                                        <th>Capacité de distribution hors PIC</th>  -->
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${tournees}" var="tournee" varStatus="vs">
	                                    <tr class="odd gradeX">
	                                    	<td>${tournee.numTournee}</td>
	                                    	<td>${tournee.secteur.codePostal}</td>
	                                        <td>${tournee.dateCreationTournee}</td>
	                                        <td>${tournee.natureTournee}</td>
	                                        <td>${tournee.statutTournee}</td>
	                                        <td>${tournee.typeTournee}</td>
	                                        <td>${tournee.typeZone}</td>
	                                        <td>${tournee.dateMaj}</td>
	                                        <td>${tournee.typeHabitatDominant}</td>
	                                        <td>${tournee.moyenLocomotion}</td>
	                                        <td>
																	<div align="center">
																		<a href="" data-toggle="modal" data-target="#detailstournee${vs.index}">
																			<img
																			src="<%=request.getContextPath()%>/resources/img/viewdetails.png"
																			alt="Voir détails" class="img-rounded" width="25" />
																		</a>
																	</div>
																	<!-- Start Modal -->
																	<div class="modal fade" id="detailstournee${vs.index}" role="dialog">
																		<div class="modal-dialog modal-sm">
																			<div class="modal-content">
																				<div class="modal-header">
																					<button type="button" class="close"
																						data-dismiss="modal">&times;</button>
																					<h4 class="modal-title">Tournée : ${tournee.secteur.codePostal}-${tournee.numTournee}</h4>
																				</div>
																				<div class="modal-body">
																					<p style="align:center;">Détails</p>
																					<h6>Trajet total :
																						${tournee.trajetTotal}</h6>
																					<h6>Montant mensuel de l'indémnité en KM : 
																						${tournee.montantMensuelIndemniteKm}</h6>
																					<h6>Fréquence de distribution hebdomadaire : 
																						${tournee.frequenceDistributionHebdomadaire}</h6>
																					<h6>Fréquence de distribution par jour : 
																						${tournee.frequenceDistributionJour}</h6>
																					<h6>Capacité de distribution PIC : 
																						${tournee.capaciteDistributionPIC}</h6>
																					<h6>Capacité de distribution hors PIC : 
																						${tournee.capaciteDistributionHorsPIC}</h6>
																					<h6>Observation tournée : 
																						${tournee.observationTournee}</h6>
																				</div>
																				<div class="modal-footer">
																					<button type="button" class="btn btn-default"
																						data-dismiss="modal">Fermer</button>
																				</div>
																			</div>
																		</div>
																	</div>
																	<!-- End Modal -->
															</td>
															<td>
																<div align="center">
																<a href="#" class="deletelink" data-tournee-id="${tournee.idT}" > 
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
							<h4 id="modaltitle" class="modal-title">Mise à jour - tournée : ${tournee.secteur.codePostal}-${tournee.numTournee} </h4>
						</div>
						<div class="modal-body">
	                                    
	             <div class="stepwizard col-md-offset-3">
					<div class="stepwizard-row setup-panel">
						<div class="stepwizard-step">
							<a href="#step-1${vs.index}" type="button"
								class="btn btn-primary btn-circle">1</a>
							<p>Informations générales</p>
						</div>
						<div class="stepwizard-step">
							<a href="#step-2${vs.index}" type="button"
								class="btn btn-default btn-circle" disabled="disabled">2</a>
							<p>Détails de la tournée</p>
						</div>
					</div>
				</div>

				<form role="form" action="<%=request.getContextPath()%>/tournee/modifier/${tournee.idT}?codepostal=${tournee.secteur.codePostal}" method="post">
					<div class="row setup-content" id="step-1${vs.index}">
						<div class="col-xs-6 col-md-offset-3">
							<div class="col-md-12">
								<h3>Informations générales</h3>
								<div class="form-group">
									<label class="control-label">Numéro de la tournée</label> 
									<input id="numTournee" name="numTournee" maxlength="100" type="number" 
										   required="required" class="form-control"
										   placeholder="Entrer le numéro de la tournée" value="${tournee.numTournee}" readonly="readonly"/>
								</div>
								<div class="form-group">
									<label class="control-label">Code postal du secteur</label> 
										<select id="codePostal" name="codePostal" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le code postal</option>
											<c:forEach items="${secteurs}" var="secteur">
												<option>${secteur.codePostal}</option>
											</c:forEach>
										</select>
								</div>
								<div class="form-group">
									<label class="control-label">Date de création de la tournée</label> 
									<input id="dateCreationTournee" name="dateCreationTournee" maxlength="100"
										   type="date" required="required"
										   class="form-control" value="${tournee.dateCreationTournee}"/>
								</div>
								<div class="form-group">
									<label class="control-label">Nature de la tournée</label> 
										<select id="natureTournee" name="natureTournee" required="required" class="form-control">
											<option  disabled="disabled">Choisir la nature de la tournée</option>
											<c:if test="${tournee.natureTournee=='MIXTE'}">
												<option selected="selected" >MIXTE</option>
												<option>COURRIER</option>
												<option>MESSAGERIE</option>
											</c:if>
											<c:if test="${tournee.natureTournee=='COURRIER'}">
												<option>MIXTE</option>
												<option selected="selected" >COURRIER</option>
												<option>MESSAGERIE</option>
											</c:if>
											<c:if test="${tournee.natureTournee=='MESSAGERIE'}">
												<option>MIXTE</option>
												<option>COURRIER</option>
												<option selected="selected" >MESSAGERIE</option>
											</c:if>
										</select>
								</div>
								
								
								
								<div class="form-group">
									<label class="control-label">Statut de la tournée</label> 
										<select id="statutTournee" name="statutTournee" required="required" class="form-control">
											<option disabled="disabled">Choisir le statut de la tournée</option>
											<c:if test="${tournee.statutTournee=='A'}">
												<option selected="selected" >A</option>
												<option>NA</option>
											</c:if>
											<c:if test="${tournee.statutTournee=='NA'}">
												<option>A</option>
												<option selected="selected" >NA</option>
											</c:if>
										</select>
								</div>
								
								
								<div class="form-group">
									<label class="control-label">Type de la tournée</label> 
										<select id="typeTournee" name="typeTournee" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le type de la tournée</option>
											<c:if test="${tournee.typeTournee=='M'}">
												<option selected="selected" >M</option>
												<option>P</option>
											</c:if>
											<c:if test="${tournee.typeTournee=='P'}">
												<option>M</option>
												<option selected="selected" >P</option>
											</c:if>
										</select>
								</div>
								
								
								<div class="form-group">
									<label class="control-label">Type de la zone</label> 
										<select id="typeZone" name="typeZone" required="required" class="form-control">
											<option disabled="disabled">Choisir le type de la zone</option>
											<c:if test="${tournee.typeZone=='U'}">
												<option selected="selected" >U</option>
												<option>R</option>
											</c:if>
											<c:if test="${tournee.typeZone=='R'}">
												<option>U</option>
												<option selected="selected" >R</option>
											</c:if>
										</select>
								</div>
								
								
								
								
								
								<div class="form-group">
									<label class="control-label">Date de mise à jour de la tournée</label> 
									<input id="dateMaj" name="dateMaj" maxlength="100" type="date" required="required" class="form-control"  value="${tournee.dateMaj}" />
								</div>
								
								
								<div class="form-group">
									<label class="control-label">Type d'habitat dominant</label> 
										<select multiple="multiple" id="typeHabitatDominant" name="typeHabitatDominant" required="required" class="form-control">
											<option disabled="disabled">Choisir le type d'habitat dominant</option>
											
											<c:if test="${tournee.typeHabitatDominant=='RESIDENTIEL'}">
													<option selected="selected" >RESIDENTIEL</option>
													<option>VILLAS</option>
													<option>IMMEUBLES</option>
													<option>INDUSTRIEL</option>
													<option>R+2</option>
													<option>R+3</option>
													<option>R+4</option>
											</c:if>
											
											<c:if test="${tournee.typeHabitatDominant=='VILLAS'}">
													<option>RESIDENTIEL</option>
													<option selected="selected" >VILLAS</option>
													<option>IMMEUBLES</option>
													<option>INDUSTRIEL</option>
													<option>R+2</option>
													<option>R+3</option>
													<option>R+4</option>
											</c:if>
											
											<c:if test="${tournee.typeHabitatDominant=='IMMEUBLES'}">
													<option>RESIDENTIEL</option>
													<option>VILLAS</option>
													<option selected="selected" >IMMEUBLES</option>
													<option>INDUSTRIEL</option>
													<option>R+2</option>
													<option>R+3</option>
													<option>R+4</option>
											</c:if>
											
											<c:if test="${tournee.typeHabitatDominant=='INDUSTRIEL'}">
													<option>RESIDENTIEL</option>
													<option>VILLAS</option>
													<option>IMMEUBLES</option>
													<option selected="selected" >INDUSTRIEL</option>
													<option>R+2</option>
													<option>R+3</option>
													<option>R+4</option>
											</c:if>
											
											<c:if test="${tournee.typeHabitatDominant=='R+2'}">
													<option>RESIDENTIEL</option>
													<option>VILLAS</option>
													<option>IMMEUBLES</option>
													<option>INDUSTRIEL</option>
													<option selected="selected" >R+2</option>
													<option>R+3</option>
													<option>R+4</option>
											</c:if>
											
											<c:if test="${tournee.typeHabitatDominant=='R+3'}">
													<option>RESIDENTIEL</option>
													<option>VILLAS</option>
													<option>IMMEUBLES</option>
													<option>INDUSTRIEL</option>
													<option>R+2</option>
													<option selected="selected" >R+3</option>
													<option>R+4</option>
											</c:if>
											
											<c:if test="${tournee.typeHabitatDominant=='R+4'}">
													<option>RESIDENTIEL</option>
													<option>VILLAS</option>
													<option>IMMEUBLES</option>
													<option>INDUSTRIEL</option>
													<option>R+2</option>
													<option>R+3</option>
													<option selected="selected" >R+4</option>
											</c:if>
											
										</select>
								</div>
								
								<div class="form-group">
									<label class="control-label">Moyen locomotion</label> 
										<select id="typeMoyenLocomotion" name="typeMoyenLocomotion" required="required" class="form-control">
											<option disabled="disabled">Choisir le moyen de locomotion</option>
											<c:if test="${tournee.typeMoyenLocomotion=='CYCLOMOTEUR'}">
												<option selected="selected" >CYCLOMOTEUR</option>
												<option>SCOOTER</option>
												<option>VELO</option>
												<option>VEHICULE</option>
											</c:if>
											<c:if test="${tournee.typeMoyenLocomotion=='SCOOTER'}">
												<option>CYCLOMOTEUR</option>
												<option selected="selected" >SCOOTER</option>
												<option>VELO</option>
												<option>VEHICULE</option>
											</c:if>
											<c:if test="${tournee.typeMoyenLocomotion=='VELO'}">
												<option>CYCLOMOTEUR</option>
												<option>SCOOTER</option>
												<option selected="selected" >VELO</option>
												<option>VEHICULE</option>
											</c:if>
											<c:if test="${tournee.typeMoyenLocomotion=='VEHICULE'}">
												<option>CYCLOMOTEUR</option>
												<option>SCOOTER</option>
												<option>VELO</option>
												<option selected="selected" >VEHICULE</option>
											</c:if>
										</select>
								</div>
								<button class="btn btn-primary nextBtn btn-lg pull-right" type="button">Suivant</button>
							</div>
						</div>
					</div>
					<div class="row setup-content" id="step-2${vs.index}">
						<div class="col-xs-6 col-md-offset-3">
							<div class="col-md-12">
								<h3>Détails</h3>
								<br>
								<div class="form-group">
									<label class="control-label">Trajet total</label> 
									<input id="trajetTotal" name="trajetTotal" maxlength="200" type="number"
										   required="required" class="form-control"
										   placeholder="Saisir la valeur du trajet total" value="${tournee.trajetTotal}" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Montant mensuel de l'indémnité en KM</label> 
									<input id="montantMensuelIndemniteKm" name="montantMensuelIndemniteKm" maxlength="200"
										   type="number" required="required" class="form-control"
										   placeholder="Saisir le montant mensuel de l'indémnité en KM" value="${tournee.montantMensuelIndemniteKm}" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Fréquence de distribution hebdomadaire</label> 
									<input id="frequenceDistributionHebdomadaire" name="frequenceDistributionHebdomadaire"
										   maxlength="200" type="number" required="required" class="form-control"
										   placeholder="Saisir la fréquence de distribution hebdomadaire" value="${tournee.frequenceDistributionHebdomadaire}" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Fréquence de distribution par jour</label> 
									<input id="frequenceDistributionJour" name="frequenceDistributionJour" maxlength="200"
										   type="number" required="required" class="form-control"
										   placeholder="Saisir la fréquence de distribution par jour" value="${tournee.frequenceDistributionJour}" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Capacité de distribution PIC</label> 
									<input id="capaciteDistributionPIC" name="capaciteDistributionPIC" maxlength="200"
									       type="number" required="required" class="form-control"
									       placeholder="Saisir la capacité de distribution PIC" value="${tournee.capaciteDistributionPIC}" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Capacité de distribution hors PIC</label> 
									<input id="capaciteDistributionHorsPIC" name="capaciteDistributionHorsPIC" maxlength="200"
										   type="number" required="required" class="form-control"
										   placeholder="Saisir la capacité de distribution hors PIC" value="${tournee.capaciteDistributionHorsPIC}" />
								</div>
								<br>
								<div class="form-group">
									<label class="control-label">Observation de la tournée</label>
									<textarea id="observationTournee" name="observationTournee"
											  required="required" class="form-control" placeholder="Entrer l'observation">${tournee.observationTournee}</textarea>
								</div>
								<br>
								<button class="btn btn-success btn-lg pull-right" type="submit">Enregistrer</button>
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
			
		</section><! --/wrapper -->
		
		<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">Confirmation de la suppression</div>
						<div class="modal-body">Voulez-vous vraiment supprimer cette tournée ?</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
							<a id="del" class="btn btn-danger btn-ok">Supprimer</a>
						</div>
					</div>
				</div>
		</div>
		
		
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              Powered by Rachid KABBAB - 2017
              <a href="blank.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
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
    
    <script type="text/javascript">
    $(document).ready(function() {
		$(".deletelink").click(function() {
				var tourneeId = $(this).data("tournee-id");
				$('#confirm-delete').modal('show');
				$('#del').attr("href","supprimer/"+tourneeId);
		});
	});
    </script>
    
    <script src="<%=request.getContextPath() %>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!--script for this page-->
    
  <script>
  $(document).ready(function() {
      $('#dataTables-example').DataTable({
          responsive: true
      });
  });
  
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>
