<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>Importer & Exporter - Facteurs</title>

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
          	<h3><i class="fa fa-angle-right"></i> Blank Page</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          		<p>Place your content here.</p>
							<div class="col-lg-6">
									<h2>Importer une liste de facteurs</h2>
									<p>Cliquez sur le button pour charger une liste des facteurs depuis un fichier Excel</p>
									<br>
							<c:if test="${! empty errorMsg}">
								<div class="alert alert-danger">
									<strong>Erreur!</strong> ${errorMsg}
								</div>
							</c:if>
							<h6> <b style="color: black; size: 1em;" > Fichier Excel d'importation </b></h6>

							<form action="${pageContext.request.contextPath}/facteur/importfacteurs" method="post" enctype="multipart/form-data">
									 <div  style="border: dashed thin black ; padding: 1%; "  >
										<input type="file" name="excelfile" />
									</div>
								<p>
									<br>
									<input type="submit"
										class="btn btn-warning btn-lg"
										class="glyphicon glyphicon-upload" value="Importer une liste de facteurs" /> 
								</p> 
							</form>
							<br>
							<h2>Téléchargement d'un modèle</h2>
							<p align="justify"> Vous pouvez télécharger un modèle de fichier Excel que vous pouvez remplir. c'est un fichier structuré afin de permettre une importation réussie. 
								les entêtes des colonnes sont commentés (le type de données que vous devez saisir. plus si la donnée est obligatoire ou non)
							</p>
							<br>
							<div>
								<div style="float: left;" >
									<img style="display: block;"  src="<%=request.getContextPath() %>/resources/img/excel2003.png" width="95" />
								</div>
								<div style="margin-left: 100px;">							
								<h5><b><span>Télécharger le modèle Excel 97-2003</span></b></h5>
								<p>Ce modèle est pour Excel 97-2003, ayant l'extension <i>.xls</i>.</p>
								<p>
							        <a style="padding:4px" href="<%=request.getContextPath() %>/download/fexcel97to2003/" class="btn btn-info btn-lg">
						    	        <span class="glyphicon glyphicon-download-alt"></span> Télecharger ce modèle
							        </a>
      							</p> 
      							</div>
							</div>
							<br>
							<div>
								<div style="float: left;" >
									<img style="display: block;"  src="<%=request.getContextPath() %>/resources/img/excel2013.png" width="95" />
								</div>
								<div style="margin-left: 100px;">							
								<h5><b><span>Télécharger le modèle Excel 2007+</span></b></h5>
								<p>Ce modèle est pour Excel 2007, 2010, 2013 etc, ayant l'extension <i>.xlsx</i>.</p>
								<p>
							        <a style="padding:4px" href="<%=request.getContextPath() %>/download/fexcel2007plus/" class="btn btn-info btn-lg">
						    	        <span class="glyphicon glyphicon-download-alt"></span> Télecharger ce modèle
							        </a>
      							</p> 
      							</div>
							</div>
							</div>
							<div class="col-lg-6">
									<h2>Exportation de la liste des facteurs</h2>
									<p align="justify"> En cliquant sur le button "Exporter la liste des facteurs", vous allez générer un fichier Excel où chaque ligne représente un facteur avec ses mesures de tenue et sa situation actuelle.  </p>
									<a href="<%=request.getContextPath() %>/facteur/exportlistfact/" class="btn btn-warning btn-lg"> 
										<span class="glyphicon glyphicon-export"></span>  Exporter la liste des facteurs
									</a>
							</div>		
							</div>
					</div>
          	</div>
			
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

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


    <!--common script for all pages-->
    <script src="<%=request.getContextPath()%>/resources/js/common-scripts.js"></script>

    <!--script for this page-->
    
  <script>
			//custom select box

			$(function() {
				$('select.styled').customSelect();
			});
		</script>

  </body>
</html>
