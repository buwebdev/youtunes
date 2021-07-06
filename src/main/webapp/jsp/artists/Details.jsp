	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="youtunes.model.Artist" %>
    
<jsp:useBean id="artistDao" scope="application" class="youtunes.service.impl.JdbcArtistDao" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouTunes | Artist Details</title>
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
	<h2>Artist Details</h2>
	
	<% 
		try 
		{
			String artistId = request.getParameter("artistId");
			Artist artist = artistDao.find(Long.parseLong(artistId)); 
			
			if (artist != null)
			{
			%>
				<form>
					<input type="hidden" name="action" value="updateArtist" />
					<input type="hidden" name="artistId" value="<%=artist.getArtistId() %>" />
					
					<div class="mb-3">
						<label for="firstName" class="form-label">First name</label>
						<input type="text" class="form-control" id="firstName" name="firstName" value="<%=artist.getFirstName() %>" />
					</div>
					
					<div class="mb-3">
						<label for="lastName" class="form-label">Last name</label>
						<input type="text" class="form-control" id="lastName" name="lastName" value="<%=artist.getLastName() %>" />
					</div>
					
					<button type="submit" class="btn btn-primary float-end">Save</button>
				</form>
				<%
				System.out.println(artist.getFirstName());
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	%>
	<br />
	<br />
	<a href="store?action=showArtists">Return to artists</a>
</div>

<jsp:include page="../ScriptFooter.jsp" flush="true" />

</body>
</html>