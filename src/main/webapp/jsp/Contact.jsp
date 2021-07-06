<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouTunes | Contact Us</title>
<!--  Bootstrap StyleSheet CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
<link 
 	rel="stylesheet" 
 	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
    integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" 
    crossorigin="anonymous">
    
<link rel="stylesheet" href="/youtunes/css/site.css" type="text/css" />
    
</head>
    
</head>
<body>
<jsp:include page="TopNav.jsp" flush="true" />

<!-- start of container -->
<div class="container py-5 width-35">
	<div class="row">
		<div class="col-12 text-center">
			<h3>Welcome to the contact page.</h3>
		</div>
	</div>
	
	<br /><br />
	
	<!--  start of the row -->
	<div class="row">
		<!--  start of the six column -->
		<div class="col-6">
			<div class="row text-center">
				<div class="col-12">
					<h1><i class="fas fa-location-arrow text-secondary"></i></h1>
				</div>
			</div>
			
			<div class="row text-center">
				<div class="col-12">
					<ul class="list-group">
						<li class="list-group-item border-0">1000 Galvin Road South</li>
						<li class="list-group-item border-0">Bellevue, Nebraska 68005</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- end of six column -->
		
		<!-- start of the six column -->
		<div class="col-6">
			<div class="row text-center">
				<div class="col-12">
					<h1><i class="fas fa-phone text-secondary"></i></h1>
				</div>
			</div>
			
			<div class="row text-center">
				<div class="col-12">
					<ul class="list-group">
						<li class="list-group-item border-0">Direct: 555.555.5555</li>
						<li class="list-group-item border-0">Toll-free: 1.800.555.5555</li>
						<li class="list-group-item border-0">Fax: 555.555.5555</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- end of six column -->
	</div>
	<!-- end of the row -->
</div>
<!-- end of container -->

<jsp:include page="ScriptFooter.jsp" flush="true" />

</body>
</html>