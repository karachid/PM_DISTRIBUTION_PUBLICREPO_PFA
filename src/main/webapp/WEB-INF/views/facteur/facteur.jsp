<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>PM - DISTRIBUTION</title>

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
          	<h3><i class="fa fa-angle-right"></i>Facteurs</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          		<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            Liste des facteurs
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
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
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${facteurs}" var="facteur">
	                                    <tr class="odd gradeX">
	                                    	<td>${facteur.matricule}</td>
	                                        <td>${facteur.nom}</td>
	                                        <td>${facteur.prenom}</td>
	                                        <td>${facteur.sexe}</td>
	                                        <td>${facteur.dateNaissance}</td>
	                                        <td>${facteur.dateRecrutement}</td>
	                                        <td>${facteur.observation}</td>
	                                        <td>
	                                        <!--<c:if test="${fn:length(facteur.tournees) gt 0}">
													<c:out value="AFFECTE"/>
											</c:if>-->
	                                        	<c:choose>
    												<c:when test="${fn:length(facteur.tournees) gt 0}">
    															<c:out value = "AFFECTE"/>
    												</c:when>    
    												<c:otherwise>
        														<c:out value = "NEANT"/>
        											</c:otherwise>
												</c:choose>
      										</td>
      										<td>
      											<!--<c:if test="${facteur.tenue}==NULL">
      													<c:out value="SANS TENUE"/>
      											</c:if>-->
      											<c:choose>
    												<c:when test="${facteur.tenue==null}">
    															<c:out value = "SANS TENUE"/>
    												</c:when>    
    												<c:otherwise>
        														<c:out value = "${facteur.tenue}"/>
        											</c:otherwise>
												</c:choose>
											</td>
	                                    </tr>
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


    <!--common script for all pages-->
    <script src="<%=request.getContextPath() %>/resources/js/common-scripts.js"></script>





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
