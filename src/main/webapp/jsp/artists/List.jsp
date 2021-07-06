<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="youtunes.model.Artist"%>

<jsp:useBean id="artistDao" scope="application"
	class="youtunes.service.impl.JdbcArtistDao" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouTunes | Artist List</title>
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

	<div class="py-5 container width-35">
	
		<h2 class="text-center">Artist List</h2>
		<br />
		
		<p class="text-center">
			<a href="store?action=newArtist" class="btn btn-outline-secondary text-center w-50">New Artist</a>
		</p>
		
		
		<table class="table">
			<thead>
				<tr>
					<th>ArtistId</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Functions</th>
				</tr>
			</thead>
			
			<%
				List<Artist> artists = artistDao.list(); 
				Iterator<Artist> iterator = artists.iterator();
				while (iterator.hasNext())
				{
					Artist artist = (Artist)iterator.next();
					System.out.println(artist.getArtistId());
					System.out.println(artist.getFirstName());
					System.out.println(artist.getLastName());
					
					// build HTML content from artist list
					%>
						<tr>
							<td><%=artist.getArtistId()%></td>
							<td><%=artist.getFirstName()%></td>
							<td><%=artist.getLastName()%></td>
							<td>
								<a href="store?action=artistDetails&artistId=<%=artist.getArtistId()%>" class="link">Edit</a> |
								<a href="store?action=deleteArtist&artistId=<%=artist.getArtistId() %>" class="link">Delete</a>
							</td>
						</tr>
				<% } %>
		</table>
	</div>

	<jsp:include page="../Footer.jsp" flush="true" />
	<jsp:include page="../ScriptFooter.jsp" flush="true" />
</body>
</html>