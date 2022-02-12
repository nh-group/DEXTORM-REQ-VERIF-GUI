
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Gamified Requirements Verification</title>
    <!-- Favicon-->
    <link rel="icon" href="favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="plugins/animate-css/animate.css" rel="stylesheet" />


<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">DEXTORM-GUI</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Test Plan Progress</h1>

			<div class="container">
				<div class="accordion" id="accordionExample">
					<c:forEach items="${issues}" var="issue" varStatus="loop">

						<div class="card" id="issue${issue.getNumber()}" hits=0>
							<div class="card-header disabled" id="heading${loop.index}">
								<h2 class="mb-0">
									<button class="btn btn-link collapsed" type="button"
										data-toggle="collapse" data-target="#collapse${loop.index}"
										aria-expanded="true" aria-controls="collapse${loop.index}">
										#${issue.getNumber()} ${issue.getTitle()}</button>
									<c:forEach items="${issue.getLabels()}" var="label">
										<button type="button" class="btn btn-info">
											${label.getName()}</button>
									</c:forEach>
									<button type="button" class="btn remover btn-danger" style="display:none">Validate
									</button>
									<div class="ignitable" ></div>
								</h2>
							</div>

							<div id="collapse${loop.index}" class="collapse"
								aria-labelledby="heading${loop.index}"
								data-parent="#accordionExample">
								<div class="card-body">${issue.getBody()}</div>
							</div>
						</div>

					</c:forEach>
				</div>
			</div>


		</div>

	</div>
	<!-- /.container -->


	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="/webjars/sockjs-client/sockjs.min.js"></script>
	<script src="/webjars/stomp-websocket/stomp.min.js"></script>
	<script src="/js/app.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript">
	$( "h1" ).progressbar({
		  classes: {
		    "ui-progressbar": "highlight"
		  },
		  value: 0,
		  max: ${issues.size()}
		});
	</script>

<body class="theme-red">
<!-- Page Loader -->
<div class="page-loader-wrapper">
    <div class="loader">
        <div class="preloader">
            <div class="spinner-layer pl-red">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>
        </div>
        <p>Please wait...</p>
    </div>
</div>
<!-- #END# Page Loader -->
<!-- Overlay For Sidebars -->
<div class="overlay"></div>
<!-- #END# Overlay For Sidebars -->
<!-- Search Bar -->
<div class="search-bar">
    <div class="search-icon">
        <i class="material-icons">search</i>
    </div>
    <input type="text" placeholder="START TYPING...">
    <div class="close-search">
        <i class="material-icons">close</i>
    </div>
</div>
<!-- #END# Search Bar -->
<!-- Top Bar -->
<nav class="navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
            <a href="javascript:void(0);" class="bars"></a>
            <a class="navbar-brand" href="/welcome"><b>Gamified Requirements Verification</b></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <!-- Call Search -->
                <li><a href="javascript:void(0);" class="js-search" data-close="true"><i class="material-icons">search</i></a></li>
                <!-- #END# Call Search -->
                <!-- Notifications -->
                <li class="dropdown">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button">
                        <i class="material-icons">notifications</i>
                        <span class="label-count">${cpt}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">NOTIFICATIONS</li>
                        <li class="body">
                            <ul class="menu">
                                <a href="localhost:8080">
                                    <div class="icon-circle bg-blue-grey">
                                        <i class="material-icons">comment</i>
                                    </div>
                                    <div class="menu-info">
                                        <h4>New Requirements</h4>
                                        <p>
                                            <i class="material-icons">${cpt} Req</i>
                                        </p>
                                    </div>
                                </a>
                            </ul>
                        </li>
                        <li class="footer">
                            <a href="javascript:void(0);">View All Notifications</a>
                        </li>
                    </ul>
                </li>
                <!-- #END# Notifications -->

                <li class="pull-right"><a href="javascript:void(0);" class="js-right-sidebar" data-close="true"><i class="material-icons">more_vert</i></a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- #Top Bar -->
<section>
    <!-- Left Sidebar -->
    <aside id="leftsidebar" class="sidebar">
        <!-- User Info -->
        <div class="user-info">
            <div class="image">
                <img src="images/med.jpg" width="48" height="48" alt="User" />
            </div>
            <div class="info-container">
                <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Mohammed TEBIB</div>
                <div class="email">lamin.teb94@gmail.com</div>
                <div class="btn-group user-helper-dropdown">
                    <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                    <ul class="dropdown-menu pull-right">
                        <li><a href="javascript:void(0);"><i class="material-icons">input</i>Sign Out</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- #User Info -->
        <!-- Menu -->
        <div class="menu">
            <ul class="list">
                <li class="header">MAIN NAVIGATION</li>
                <li class="active">
                    <a href="/welcome">
                        <i class="material-icons">home</i>
                        <span>Home</span>
                    </a>
                </li>
                <li>
                    <a href="/">
                        <i class="material-icons">layers</i>
                        <span>Status</span>
                    </a>
                </li>

            </ul>
        </div>
        <!-- #Menu -->
    </aside>
    <!-- #END# Left Sidebar -->
    <!-- Right Sidebar -->
    <aside id="rightsidebar" class="right-sidebar">
        <ul class="nav nav-tabs tab-nav-right" role="tablist">
            <li role="presentation" class="active"><a href="#skins" data-toggle="tab">SKINS</a></li>
            <li role="presentation"><a href="#settings" data-toggle="tab">SETTINGS</a></li>
        </ul>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active in active" id="skins">
                <ul class="demo-choose-skin">
                    <li data-theme="red" class="active">
                        <div class="red"></div>
                        <span>Red</span>
                    </li>
                    <li data-theme="pink">
                        <div class="pink"></div>
                        <span>Pink</span>
                    </li>
                    <li data-theme="purple">
                        <div class="purple"></div>
                        <span>Purple</span>
                    </li>
                    <li data-theme="deep-purple">
                        <div class="deep-purple"></div>
                        <span>Deep Purple</span>
                    </li>
                    <li data-theme="indigo">
                        <div class="indigo"></div>
                        <span>Indigo</span>
                    </li>
                    <li data-theme="blue">
                        <div class="blue"></div>
                        <span>Blue</span>
                    </li>
                    <li data-theme="light-blue">
                        <div class="light-blue"></div>
                        <span>Light Blue</span>
                    </li>
                    <li data-theme="cyan">
                        <div class="cyan"></div>
                        <span>Cyan</span>
                    </li>
                    <li data-theme="teal">
                        <div class="teal"></div>
                        <span>Teal</span>
                    </li>
                    <li data-theme="green">
                        <div class="green"></div>
                        <span>Green</span>
                    </li>
                    <li data-theme="light-green">
                        <div class="light-green"></div>
                        <span>Light Green</span>
                    </li>
                    <li data-theme="lime">
                        <div class="lime"></div>
                        <span>Lime</span>
                    </li>
                    <li data-theme="yellow">
                        <div class="yellow"></div>
                        <span>Yellow</span>
                    </li>
                    <li data-theme="amber">
                        <div class="amber"></div>
                        <span>Amber</span>
                    </li>
                    <li data-theme="orange">
                        <div class="orange"></div>
                        <span>Orange</span>
                    </li>
                    <li data-theme="deep-orange">
                        <div class="deep-orange"></div>
                        <span>Deep Orange</span>
                    </li>
                    <li data-theme="brown">
                        <div class="brown"></div>
                        <span>Brown</span>
                    </li>
                    <li data-theme="grey">
                        <div class="grey"></div>
                        <span>Grey</span>
                    </li>
                    <li data-theme="blue-grey">
                        <div class="blue-grey"></div>
                        <span>Blue Grey</span>
                    </li>
                    <li data-theme="black">
                        <div class="black"></div>
                        <span>Black</span>
                    </li>
                </ul>
            </div>
            <div role="tabpanel" class="tab-pane fade" id="settings">
                <div class="demo-settings">
                    <p>GENERAL SETTINGS</p>
                    <ul class="setting-list">
                        <li>
                            <span>Report Panel Usage</span>
                            <div class="switch">
                                <label><input type="checkbox" checked><span class="lever"></span></label>
                            </div>
                        </li>
                        <li>
                            <span>Email Redirect</span>
                            <div class="switch">
                                <label><input type="checkbox"><span class="lever"></span></label>
                            </div>
                        </li>
                    </ul>
                    <p>SYSTEM SETTINGS</p>
                    <ul class="setting-list">
                        <li>
                            <span>Notifications</span>
                            <div class="switch">
                                <label><input type="checkbox" checked><span class="lever"></span></label>
                            </div>
                        </li>
                        <li>
                            <span>Auto Updates</span>
                            <div class="switch">
                                <label><input type="checkbox" checked><span class="lever"></span></label>
                            </div>
                        </li>
                    </ul>
                    <p>ACCOUNT SETTINGS</p>
                    <ul class="setting-list">
                        <li>
                            <span>Offline</span>
                            <div class="switch">
                                <label><input type="checkbox"><span class="lever"></span></label>
                            </div>
                        </li>
                        <li>
                            <span>Location Permission</span>
                            <div class="switch">
                                <label><input type="checkbox" checked><span class="lever"></span></label>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </aside>
    <!-- #END# Right Sidebar -->
</section>

<section class="content">
    <div class="container-fluid">
        <div class="block-header">
            <h2>TASKS</h2>
        </div>

        <!-- Widgets -->
        <div class="row clearfix">
            <div onclick='display_live();'  class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-cyan hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">playlist_add_check</i>
                    </div>
                    <div  class="content">
                        <div class="text" >Live Requirements Console</div>
                        <div class="number count-to" data-from="0" data-to="${cpt}" data-speed="15" data-fresh-interval="20"></div>
                    </div>
                </div>
            </div>
            <div onclick='display_issues();' class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-orange hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">playlist_add_check</i>
                    </div>
                    <div class="content">
                        <div class="text">Issues</div>
                        <div class="number count-to" data-from="0" data-to="0" data-speed="15" data-fresh-interval="20"></div>
                    </div>
                </div>
            </div>

        </div>
        <!-- #END# Widgets -->

        <div class="row clearfix">
            <!-- Task Info -->
            <div id="req" class="col-xs-12 col-sm-12 col-md-8 col-lg-7">
                <div class="card">
                    <div class="header">
                        <h2>Live Requirements</h2>
                        <ul class="header-dropdown m-r--5">
                            <li class="dropdown">
                                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <i class="material-icons">more_vert</i>
                                </a>
                                <ul class="dropdown-menu pull-right">
                                    <li><a href="javascript:void(0);">Action</a></li>
                                    <li><a href="javascript:void(0);">Another action</a></li>
                                    <li><a href="javascript:void(0);">Something else here</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="body">
                        <div class="table-responsive">
                            <table class="table table-hover dashboard-task-infos">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Requirement</th>
                                    <th>Status</th>
                                    <th>Progress</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${message}" var="item">
                                    <tr>
                                        <td id="counter"></td>
                                        <td>Requierement   <a href="${item.getIssueURI()}">${item.getId()}</a> </td>
                                        <td><span class="label bg-blue">To Do</span></td>
                                        <td>
                                            <div class="progress">
                                                <div class="progress-bar bg-blue" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 1%"></div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <script>
                                    var list = document.getElementsByClassName("counter");
                                    for (var i = 1; i <= list.length; i++) {
                                        list[i].innerHTML = i;
                                    }
                                </script>

                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
            <!-- #END# Task Info -->

            <!-- Features -->
            <div id="features" class="col-xs-12 col-sm-12 col-md-8 col-lg-5">
                <div class="card">
                    <div class="header">
                        <h2>Requirements Features</h2>
                        <ul class="header-dropdown m-r--5">
                            <li class="dropdown">
                                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <i class="material-icons">more_vert</i>
                                </a>
                                <ul class="dropdown-menu pull-right">
                                    <li><a href="javascript:void(0);">Action</a></li>
                                    <li><a href="javascript:void(0);">Another action</a></li>
                                    <li><a href="javascript:void(0);">Something else here</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="body">
                        <div id="accordion">
                            <div class="card">
                                <div class="card-header" id="headingOne">
                                    <table class="table table-hover dashboard-task-infos">

                                        <tr data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne" >
                                            <td width="70%">
                                                <span>Ambiguity</span>
                                            </td>
                                            <td>
                                                <div class="switch">
                                                    <label><input type="checkbox" ><span class="lever"></span></label>
                                                </div>
                                            </td>
                                        </tr>

                                        <div class="col-lg-12"  id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="Report">
                                                <span class="input-group-btn">
                                                                   <button class="btn btn-primary" type="button">Submit</button>
                                                                  </span>
                                            </div>
                                        </div>
                                    </table>
                                </div>
                            </div>

                            <div class="card">
                                <div class="card-header" id="headingTwo">
                                    <table class="table table-hover dashboard-task-infos">

                                        <tr data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                            <td width="70%">
                                                <span>Overspecification</span>
                                            </td>
                                            <td>
                                                <div class="switch">
                                                   <form role="form" method="POST" th:object="$Report">
                                                    <label><input type="checkbox" ><span class="lever"></span></label>
                                                   </form>
                                                </div>
                                            </td>
                                        </tr>

                                        <div class="col-lg-12"  id="collapseTwo" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="Report">
                                                <span class="input-group-btn">
                                                                   <button class="btn btn-primary" type="button">Submit</button>
                                                                  </span>
                                            </div>
                                        </div>
                                    </table>
                                </div>
                            </div>

                            <div class="card">
                                <div class="card-header" id="headingThree">
                                    <table class="table table-hover dashboard-task-infos">

                                        <tr data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseTHree">
                                            <td width="70%">
                                                <span>Inconsistency</span>
                                            </td>
                                            <td>
                                                <div class="switch">
                                                    <label><input type="checkbox" ><span class="lever"></span></label>
                                                </div>
                                            </td>
                                        </tr>

                                        <div class="col-lg-12"  id="collapseThree" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="Report">
                                                <span class="input-group-btn">
                                                                   <button class="btn btn-primary" type="button">Submit</button>
                                                                  </span>
                                            </div>
                                        </div>
                                    </table>
                                </div>
                            </div>

                            <div class="card">
                                <div class="card-header" id="headingFour">
                                    <table class="table table-hover dashboard-task-infos">

                                        <tr data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                            <td width="70%">
                                                <span>Infeasibility</span>
                                            </td>
                                            <td>
                                                <div class="switch">
                                                    <label><input type="checkbox" ><span class="lever"></span></label>
                                                </div>
                                            </td>
                                        </tr>

                                        <div class="col-lg-12"  id="collapseFour" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="Report">
                                                <span class="input-group-btn">
                                                                   <button class="btn btn-primary" type="button">Submit</button>
                                                                  </span>
                                            </div>
                                        </div>
                                    </table>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="headingFive">
                                    <table class="table table-hover dashboard-task-infos">

                                        <tr data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                            <td width="70%">
                                                <span>Underspecification</span>
                                            </td>
                                            <td>
                                                <div class="switch">
                                                    <label><input type="checkbox" ><span class="lever"></span></label>
                                                </div>
                                            </td>
                                        </tr>

                                        <div class="col-lg-12"  id="collapseFive" class="collapse show" aria-labelledby="headingFive" data-parent="#accordion">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="Report">
                                                <span class="input-group-btn">
                                                                   <button class="btn btn-primary" type="button">Submit</button>
                                                                  </span>
                                            </div>
                                        </div>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Task Info -->
        </div>

    </div>
</section>


<script src="plugins/bootstrap/js/bootstrap.js"></script>
<!-- Select Plugin Js -->
<script src="plugins/bootstrap-select/js/bootstrap-select.js"></script>
<!-- Jquery Core Js -->
<script src="plugins/jquery/jquery.min.js"></script>

<!-- Bootstrap Core Js -->


<!-- Slimscroll Plugin Js -->
<script src="plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

<!-- Waves Effect Plugin Js -->
<script src="plugins/node-waves/waves.js"></script>

<!-- Jquery CountTo Plugin Js -->
<script src="plugins/jquery-countto/jquery.countTo.js"></script>

<!-- Morris Plugin Js -->
<script src="plugins/raphael/raphael.min.js"></script>
<script src="plugins/morrisjs/morris.js"></script>

<!-- ChartJs -->
<script src="plugins/chartjs/Chart.bundle.js"></script>

<!-- Flot Charts Plugin Js -->
<script src="plugins/flot-charts/jquery.flot.js"></script>
<script src="plugins/flot-charts/jquery.flot.resize.js"></script>
<script src="plugins/flot-charts/jquery.flot.pie.js"></script>
<script src="plugins/flot-charts/jquery.flot.categories.js"></script>
<script src="plugins/flot-charts/jquery.flot.time.js"></script>

<!-- Sparkline Chart Plugin Js -->
<script src="plugins/jquery-sparkline/jquery.sparkline.js"></script>

<!-- Custom Js -->
<script src="js/admin.js"></script>
<script src="js/pages/index.js"></script>

<!-- Demo Js -->
<script src="js/demo.js"></script>


<script src="js/myjs.js"></script>

<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>

</html>
