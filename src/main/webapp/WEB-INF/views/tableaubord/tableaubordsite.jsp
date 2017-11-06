<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
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
    
    
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
	
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1.0', {
        'packages' : [ 'corechart' ]
    });
 
    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(init);
    
    function init(){
    	drawChart();
    	drawSecChart();
    	drawThrChart();
    	drawFouChart();
    }
    
    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {
 
        // Create the data table.    
        var data = google.visualization.arrayToDataTable([
                                                              ['Secteur', 'nbreTournees'],
                                                              <c:forEach items="${tourneesPArSecteur}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);
        // Set chart options
        var options = {
        			'title' : 'Nombre de tournees par secteur',
                    is3D : true,
                    backgroundColor: '#E4E4E4',
                    pieSliceText: 'label',
                    tooltip :  {showColorCode: true},
                    'width' : 500,
                    'height' : 300
        };
 
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);        
    }
    
    function drawSecChart() {
    	 
        // Create the data table.    
        var data = google.visualization.arrayToDataTable([
                                                              ['Secteur', 'nbreTournees'],
                                                              <c:forEach items="${tourneesPArSecteur}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);
        // Set chart options
        var options = {
        			'title' : 'Nombre de tournees par secteur',
                    is3D : true,
                    backgroundColor: '#E4E4E4',
                    pieSliceText: 'label',
                    tooltip :  {showColorCode: true},
                    'width' : 500,
                    'height' : 300
        };
 
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart2_div'));
        chart.draw(data, options);        
    }
    
    
    function drawThrChart() {
    	  // Create the data table.    
        var data = google.visualization.arrayToDataTable([
                                                              ['Secteur', 'nbreTournees'],
                                                              <c:forEach items="${tourneesPArSecteur}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);
        // Set chart options
        var options = {
        			'title' : 'Nombre de tournees par secteur',
                    is3D : true,
                    backgroundColor: '#E4E4E4',
                    pieSliceText: 'label',
                    tooltip :  {showColorCode: true},
                    'width' : 500,
                    'height' : 300
        };
 
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart4_div'));
        chart.draw(data, options);        
    }
    
    function drawFouChart() {
  	  // Create the data table.    
        var data = google.visualization.arrayToDataTable([
                                                              ['Secteur', 'nbreFacteurs'],
                                                              <c:forEach items="${FacteursParSecteur}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);
  	  
        // Set chart options
        var options = {
        		legend: 'none',
                pieSliceText: 'label',
                backgroundColor: '#E4E4E4',
                title: 'Nombres de facteurs par secteur',
                pieStartAngle: 100,
                'width' : 500,
                'height' : 300
        };
 
        // Instantiate and draw our chart, passing in some options.
         // Instantiate and draw the chart.
   		var chart = new google.visualization.ColumnChart(document.getElementById('chart3_div'));
   		chart.draw(data, options);   
      }
    
</script>
    
    
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
          		
          		<div class="col-lg-6">          			
          			<div style="padding:10px" id="chart_div">
          			</div>
          			<div style="padding:10px" id="chart2_div">
          			</div>
          		</div>
          		<div class="col-lg-6">
          			<div style="padding:10px" id="chart3_div">
          			</div>
          			<div style="padding:10px" id="chart4_div">
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
