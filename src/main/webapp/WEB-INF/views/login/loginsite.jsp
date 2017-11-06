<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">

    <title>PM DISTRIBUTION - Login page</title>

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

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" method="POST" action="<%=request.getContextPath() %>/login/logincheckersite/" onsubmit="return validate()">
		        <h2 class="form-login-heading">Connectez vous : ${type}</h2>
		        <div class="login-wrap">
		        <c:if test="${! empty msgEmptyFields}">
		        		<div class="alert alert-danger">
  								<strong>Erreur!</strong> ${msgEmptyFields} 
						</div>
		        </c:if>
		            <input name="login" type="text" class="form-control" placeholder="Login" autofocus required="required" >
		            <br>
		            <input name="password" type="password" class="form-control" placeholder="mot de passe" required="required">
		            <br>
		            <select id="lesRrap" class="form-control" name="nomDrap" required="required">
		            		<option selected="selected" disabled="disabled">Choisir une direction générale</option>
		            		<c:forEach items="${drapList}" var="drap">
		            			<option>
										${drap.drap}
								</option>
		            		</c:forEach>
		            </select>
		            <br>
		            <select id="lesRegions" class="form-control" name="nomRegion" required="required">
		            			<option selected="selected" disabled="disabled" >Choisir une région</option>
		            			<option>
								</option>
		            </select>
		            <br>
		            <select id="lesSites" class="form-control" name="nomSite" required="required">
		            			<option selected="selected" disabled="disabled">Choisir un site</option>
		            			<option>
								</option>
		            </select>
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> Avez-vous oublié votre mot de passe?</a>
		
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> SE C0NNECTER</button>
		        </div>
		
		          <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Avez-vous oublié votre mot de passe ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>Veuillez saisir votre email pour ré-initialiser votre mot de passe.</p>
		                          <input type="text" name="" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Annuler</button>
		                          <button class="btn btn-theme" type="button">Valider</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		      </form>	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
    
    
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.backstretch.min.js"></script>
    <script type="text/javascript"> 
    
    $(document).ready(function(){
		$("#lesRegions").change(function(){
			 var regionName = $("#lesRegions option:selected").val();
			 //alert(regionName);
			 $.ajax({
				 type: "GET",
				 headers: {
					 Accept : "application/json; charset=utf-8",
					 "Content-Type": "application/json; charset=utf-8"
				 },
				 url: "http://localhost:8080/distribution/login/getSitesRegion/",
				 data: {nomRegion : regionName},
				 success: function(res){
					 	//alert("SUCCESS : " + res.length);
			            var s='<option selected="selected" disabled="disabled">Choisir un site</option>';
			            for(var i = 0; i < res.length; i++){
			            	s += '<option value="'+ res[i] + '">' + res[i] + '</option>';
			            }
			            $('#lesSites').html(s);
			        },
			        error:function(){
			           alert("error");
			        }
			 });
		});
	});
    
    	$(document).ready(function(){
    		$("#lesRrap").change(function(){
    			 var drapName = $("#lesRrap option:selected").val();
    			 //alert(drapName);
    			 $.ajax({
    				 type: "GET",
    				 headers: {
    					 Accept : "application/json; charset=utf-8",
    					 "Content-Type": "application/json; charset=utf-8"
    				 },
    				 url: "http://localhost:8080/distribution/login/getRegions/",
    				 data: {nameDrap : drapName},
    				 success: function(result){
    					 	//alert(result);
    			           /* var slctRegions = $("#lesRegions"), option= "";
    			            slctRegions.empty();
    			            alert("HERE2");
    			            for(var rg =0; rg<data.length; rg++){
    			                option = option + "<option value='" + data[rg].name + "'>" +data[rg].name + "</option>";
    			            }
    			            alert("HERE3");
    			            slctRegions.append(option);
    			            alert("HERE4");*/
    			            var s='<option selected="selected" disabled="disabled">Choisir une région</option>';
    			            for(var i = 0; i < result.length; i++){
    			            	s += '<option value="'+ result[i] + '">' + result[i] + '</option>';
    			            }
    			            $('#lesRegions').html(s);
    			        }/*,
    			        error:function(){
    			           alert("error");
    			        }*/
    			 });
    		});
    	});
    	
    	
    
        $.backstretch("<%=request.getContextPath() %>/resources/img/images.png", {speed: 500});
    </script>
  </body>
</html>
