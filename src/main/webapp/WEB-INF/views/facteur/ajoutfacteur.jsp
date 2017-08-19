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
          	<h3><i class="fa fa-angle-right"></i> Blank Page</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          		<p>Place your content here.</p>
          		
          		
          		<div class="panel panel-info">
	                        <div class="panel-heading">
	                            Nouveau facteur
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
								<form method="get" action="" >
									<div class="form-group">
                                        <label>Matricule</label>
                                        <input type="number"" class="form-control" placeholder="Matricule" required="required" />
                                    </div>
									<div class="form-group">
                                        <label>Nom</label>
                                        <input type="text" class="form-control" placeholder="Nom" required="required" />
                                    </div>
									<div class="form-group">
                                        <label>Prénom</label>
                                        <input type="text" class="form-control" placeholder="Prénom" required="required"/>
                                    </div>
									<div class="form-group">
                                        <label>Sexe</label>
                                        <input required="required" type="text" class="form-control" placeholder="Sexe" />
                                    </div>
									<div class="form-group">
                                        <label>Date de naissance" /></label>
                                        <input type="date" class="form-control" placeholder="Date de naissance" required="required"/>
                                    </div>
									<div class="form-group">
                                        <label>Date de recrutement</label>
                                        <input type="date" class="form-control" placeholder="Date de recrutement"  required="required" />
                                    </div>
                                 
                                    <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message key="Enregistrer" /></i></button>
                                    	<a href="<c:url value="/article/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<fmt:message key="Annuler" /></i></a>
                                    </div>
								</form>	                        
	                        </div>
	                        <!-- /.panel-body -->
	                    </div>
	                    <!-- /.panel -->
          		
          		
          		</div>
          	</div>
			
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is
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
