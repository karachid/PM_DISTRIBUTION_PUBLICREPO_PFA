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

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >   
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
     <!--  <section id="main-content">  -->
         <!--  <section class="wrapper site-min-height">  -->
          	<h3>Voulez vous se connecter en tant que </h3>
          	<div class="row">
          		<div class="col-lg-12" >
          		<div class="col-lg-4">
          		</div>
          		<div class="col-lg-4">
          			<!-- <img src="<%=request.getContextPath() %>/resources/img/pmlogo.jpg" alt="logo de la poste du maroc"/>  -->
          		</div>
          		<div class="col-lg-4">
          		</div>
          			<div class="col-lg-12">
          					<div class="col-lg-3">
          					</div>
          					<div class="col-lg-6">
          						<div class="col-lg-4" style="text-align : justify">
          						Connectez vous depuis le siège afin de pouvoir contrôler la tolalité des régions avec l'ensemble des sites qui y font partie 
          							<div align="center"><a href="<%=request.getContextPath() %>/login/login/siege">Siège</a></div>
          						</div>
          						<div class="col-lg-4" style="text-align : justify">
          						<!-- <img src="<%=request.getContextPath() %>/resources/img/region.jpg" width="200" height="250"/>  -->
          						Connectez vous depuis le région afin de pouvoir contrôler la tolalité des site avec l'ensemble des ressources qui y font partie
          							<div align="center"><a href="<%=request.getContextPath() %>/login/login/region">Région</a></div>
          						</div>
          						<div class="col-lg-4" style="text-align : justify">
          						Connectez vous depuis le site afin de pouvoir gérer l'effectation des ressources aux tournées et aux facteurs, et voir ses statistiques
          							<div align="center"><a href="<%=request.getContextPath() %>/login/login/site">Site</a></div>
          						</div>
          					</div>
          					<div class="col-lg-3">
          					</div>
          			</div>
          		</div>
          	</div>
			
	<!-- </section> /wrapper -->
    <!--  </section> /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
     <!--  <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is
              <a href="blank.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>  -->
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


    <!--common script for all pages-->
    <script src="<%=request.getContextPath() %>/resources/js/common-scripts.js"></script>

    <!--script for this page-->
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>
