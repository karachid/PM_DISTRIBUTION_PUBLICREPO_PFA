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
					<i class="fa fa-angle-right"></i> Affecter un facteur à une tournée
				</h3>
				<div class="row mt">
					<div class="col-lg-12">
					
			
					
				<form  role="form" action="<%=request.getContextPath() %>/affectation/affecter/" method="post">
						<div class="col-xs-6 col-md-offset-3">
							<div class="col-md-12">
							
			 	<c:if test="${! empty successmsg}">
			 			<div class="alert alert-success">
  								<strong>Opération réussie !</strong> ${successmsg}
						</div>
		        </c:if>  
							<!-- 	<h3>Informations du facteur</h3>  -->
								
								<div class="form-group">
									<label class="control-label">Date d'affectation</label> 
									<input id="df" name="df" maxlength="100" type="date" required="required" class="form-control"/>
								</div>
								
								<div class="form-group">
									<label class="control-label">Facteur</label> 
									<select id="facteurId" name="facteurId" required="required" class="form-control">
											<option selected="selected" disabled="disabled">Choisir le facteur à affecter</option>
											<c:forEach items="${factsLibres}" var="f" >
												<option value="${f.idF}" >${f.nom} &nbsp; ${f.prenom}</option>
											</c:forEach>
									</select>
								</div>
								<input value="" hidden="hidden" id="idFact" name="idFact" />		
							
								<div class="form-group">
									<label class="control-label">Secteur</label> 
										<select id="sectCp" name="sectCp" required="required" class="form-control">
											 	<option selected="selected" disabled="disabled">Choisir la tournée à affecter</option>
												<c:forEach items="${secteurs}" var="s" >
													<option value="${s.codePostal}" >${s.codePostal}</option>
												</c:forEach>
										</select>
								</div>
								
								<div class="form-group">
									<label class="control-label">Tournée</label> 
										<select id="tourneeId" name="tourneeId" required="required" class="form-control">
									</select>
								</div>
								
								<input value="" hidden="hidden" id="idTour" name="idTour" />
								
								<div class="form-group">
									<label class="control-label">Observation de l'affectation</label>
									<textarea id="observationAff" name="observationAff" required="required" class="form-control" placeholder="Entrer l'observation"></textarea>
								</div>
							
							<button class="btn btn-success btn-lg pull-right" type="submit">Affecter</button>
							
							</div>
						</div>
				</form>
					
					</div>
					</div>
			</section>

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
	
	<script type="text/javascript">

    $(document).ready(function(){
		$("#sectCp").change(function(){
			 var cp = $("#sectCp option:selected").val();
			 //alert(cp);
			 $.ajax({
				 type: "GET",
				 headers: {
					 Accept : "application/json; charset=utf-8",
					 "Content-Type": "application/json; charset=utf-8"
				 },
				 url: "http://localhost:8080/distribution/affectation/gettourneeslibres",
				 data: {codePostal : cp},
				 success: function(res){
					 	alert("SUCCESS : " + res[0]);
			            var s='<option selected="selected" disabled="disabled">Choisir la tournée à affecter</option>';
			            for(var i = 0; i < (res.length); i+=2){
			            	s += '<option value="'+ res[i] + '">' + res[i+1] + '</option>';
			            }
			            $('#tourneeId').html(s);
			        },
			        error:function(){
			           alert("error");
			        }
			 });
		});
		
		$("#facteurId").change(function(){
			var id = $(this).val();
			$('#idFact').attr('value',id);
	 	});
		
		$("#tourneeId").change(function(){
			var id = $(this).val();
			$('#idTour').attr('value',id);
		});
		
	});
	
	</script>

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
