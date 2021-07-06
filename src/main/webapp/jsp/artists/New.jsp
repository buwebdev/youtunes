<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouTunes | New Artist</title>
<!--  Bootstrap StyleSheet CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="/youtunes/css/site.css" type="text/css" />
</head>
<body>
<jsp:include page="../TopNav.jsp" flush="true" />

<div class="container py-5 width-35">
	<h2>New Artist Form</h2>
	<form>
		<input type="hidden" name="action" value="createArtist" />
					
		<div class="mb-3">
			<label for="firstName" class="form-label">First name</label>
			<input type="text" class="form-control" id="firstName" name="firstName" />
		</div>
					
		<div class="mb-3">
			<label for="lastName" class="form-label">Last name</label>
			<input type="text" class="form-control" id="lastName" name="lastName" />
		</div>
					
		<button type="submit" class="btn btn-primary float-end">Save</button>
	</form>
	
	<br /><br />
	<a href="store?action=showArtists">Return to artists</a>
</div>

<jsp:include page="../ScriptFooter.jsp" flush="true" />

</body>
</html>