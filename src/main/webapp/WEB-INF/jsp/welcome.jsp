<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	

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
	<jsp:include page="menu.jsp" />
	<div class="container mt-4 mb-4">
		<div class="starter-template">
			<div class="container mb-4" id="testPlan">
				<h1>Test Plan Progress</h1>
				<button type="button" 
						class="btn btn-primary"
						id="buttonRunAllTest"
						data-toggle="collapse"
						data-target="#runAllTest"
						aria-expanded="true" 
						aria-controls="runAllTest">
					Run all test cases
				</button>

				<div id="runAllTest" 
					class="card collapse mt-4"
					data-parent="#testPlan">
					<div class="card-body globalTestResult">
						
					</div>
				</div>

				<div class="accordion mt-4" id="accordionExample">
					<c:forEach items="${issues}" var="issue" varStatus="loop">
						<div class="card" id="issue${issue.getNumber()}" hits=0>
							<div class="card-header disabled" id="heading${loop.index}">
								<button type="button" 
										id="${issue.getNumber()}" 
										class="runTestCase btn btn-primary"
										data-toggle="collapse"
										data-target="#runTest${loop.index}"
										aria-expanded="true" 
										aria-controls="runTest${loop.index}">
									Run test case
								</button>

								<button type="button"
										class="btn btn-secondary collapsed" 
										type="button"
										data-toggle="collapse"
										data-target="#collapse${loop.index}"
										aria-expanded="true" 
										aria-controls="collapse${loop.index}">
									Show description
								</button>


								<!--
								<c:forEach items="${issue.getLabels()}" var="label">
									<button type="button" class="btn btn-info">${label.getName()}</button>
								</c:forEach>
								-->
								
								<button type="button" class="btn remover btn-danger" style="display:none">Validate</button>
								<div class="ignitable" ></div>

								<h2 class="mb-0">
									<button class="btn btn-link collapsed" 
											type="button"
											data-toggle="collapse"
											data-target="#collapse${loop.index}"
											aria-expanded="true" 
											aria-controls="collapse${loop.index}">
										#${issue.getNumber()} ${issue.getTitle()}
									</button>
								</h2>
							</div>

							<div id="collapse${loop.index}" 
								class="collapse"
								aria-labelledby="heading${loop.index}"
								data-parent="#accordionExample">
								<div class="card-body">${issue.getBody()}</div>
							</div>

							<div id="runTest${loop.index}" 
								class="collapse"
								aria-labelledby="heading${loop.index}"
								data-parent="#accordionExample">
								<div class="card-body testResult-${issue.getNumber()}"></div>
							</div>

						</div>

					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="/webjars/sockjs-client/sockjs.min.js"></script>
	<script src="/webjars/stomp-websocket/stomp.min.js"></script>
	<script src="/js/app.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/coverageProgress.js"></script>
	<script type="text/javascript">
	$( "h1" ).progressbar({
		  classes: {
		    "ui-progressbar": "highlight"
		  },
		  value: 0,
		  max: ${issues.size()}
		});

	</script>

</body>
</html>
