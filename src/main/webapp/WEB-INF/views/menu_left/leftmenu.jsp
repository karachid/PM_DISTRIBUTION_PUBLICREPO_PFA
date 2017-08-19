      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="<%=request.getContextPath() %>/resources/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">Marcel Newman</h5>
              	  	
                  <li class="mt">
                      <a class="active" href="index.html">
                          <i class="fa fa-dashboard"></i>
                          <span>Tableau de bord</span>
                      </a>
                  </li>
				<!-- Start : Sous menu Tournées -->
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Tournées</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="${pageContext.request.contextPath}/tournee/">Consutler</a></li>
                          <li><a  href="${pageContext.request.contextPath}/ajouttournee/">Ajouter</a></li>
                          <li><a  href="panels.html">Mettre à jour</a></li>
                      </ul>
                  </li>
                 <!-- End : Sous menu Tournées -->
				 
				 <!-- Start : Sous menu Facteurs -->
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Facteurs</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="${pageContext.request.contextPath}/facteur/">Consutler</a></li>
                          <li><a  href="${pageContext.request.contextPath}/facteur/ajoutfacteur/">Ajouter</a></li>
                          <li><a  href="todo_list.html">Mettre à jour</a></li>
                      </ul>
                  </li>
                  <!-- End : Sous menu Facteurs -->
                  
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Affectations</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="blank.html">Liste des affectations</a></li>
                          <li><a  href="login.html">Sous menu 2</a></li>
                          <li><a  href="lock_screen.html">Sous menu 3</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>Forms</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="form_component.html">Form Components</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>Data Tables</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="basic_table.html">Basic Table</a></li>
                          <li><a  href="responsive_table.html">Responsive Table</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class=" fa fa-bar-chart-o"></i>
                          <span>Charts</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="morris.html">Morris</a></li>
                          <li><a  href="chartjs.html">Chartjs</a></li>
                      </ul>
                  </li>

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->