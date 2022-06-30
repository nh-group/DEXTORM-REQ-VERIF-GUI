<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="container mt-100">
        <div class="row">
            <div class="col-md-12">
                <div class="card p-4">
                    <div class="card-header">
						<div class="container">
							<div class="row">
							  <div class="col">
								<h5>Parameters - Metrics</h5>
							  </div>
							  <div class="col"></div>
							  <div class="col"></div>
							  <div class="col">
								<button type="button" id="addRow" class="btn btn-success">
									<i class="fa fa-plus-circle"></i> Add metric
								</button>
								<button type="button" id="saveMetrics" class="btn btn-primary">
									<i class="fa fa-save"></i> Save
								</button>
							  </div>
							</div>
						</div>
                    </div>
                    <div class="card-block">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered" id="example-1">
                                <thead>
                                    <tr>
                                        <th>Displayed comment</th>
                                        <th>Type of metric</th>
                                        <th>Min % coverage</th>
										<th>Max % coverage</th>
										<th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		<div class="row">
			<div class="col-md-12">
				<div class="card p-4">
                    <div class="card-header">
						<div class="container">
							<div class="row">
								<h5>Repository</h5>
							</div>
						</div>
					</div>
					<div class="card-block mt-4">
						<form class="form-inline" action="/parameters" method="GET">
							<input type="text" class="form-control" name="githubRepoName" value="${githubRepoName}" />
							<input type="submit" class="btn btn-primary ml-4" value="change repository"/>
						</form>
					</div>
				</div>
			</div>
		</div>
		
    </div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="/js/metricsParameters.js"></script>
</body>
</html>
