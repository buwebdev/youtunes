<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>YouTunes | About Us</title>
<!--  Bootstrap StyleSheet CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="/youtunes/css/site.css" type="text/css" />

</head>
<body>
<jsp:include page="TopNav.jsp" flush="true" />

<div class="container py-5 width-35">
	
	<div class="row">
		<div class="col-12">
			<h3 class="text-center">Wolfgang Amadeus Mozart</h3>
		</div>
	</div>
	
	<br />
	<div class="row">
		<div class="col-4">
			<img src="/youtunes/images/youtunes-about.png" />
		</div>
		
		<div class="col-8">
			<p>
        		An Austrian composer of the Classical period, Wolfgang Amadeus Mozart is widely recognized as one of the greatest composers of Western music.
       			He is the only composer to write and excel in all of the musical genres of his time.
        		Rumored to have had the ability to play music at age three and to write music at age five, Mozart began his career as a child prodigy.
        		Notable compositions include The Marriage of Figaro, Elvira Madigan, and Clarinet Quintet in A Major, K 581. 
       			<em class="apa-reference"><a href="https://www.britannica.com/list/10-classical-music-composers-to-know" target="_blank">Source</a></em>
      		</p>
		</div>
	</div>

</div>


<jsp:include page="ScriptFooter.jsp" flush="true" />

</body>
</html>