<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
	int year = Calendar.getInstance().get(Calendar.YEAR);
	String appName = "YouTunes";
	String courseName = "CSD 460";
%>
<footer class="text-muted py-5">
	<div class="container">
		<p class="float-end mb-1">
			<a href="#">Back to top</a>
		</p>
		<p>
			&copy; <%=year%> - <%=courseName%> (<%=appName%>) | <a href="https://www.bellevue.ed" target="_blank">Bellevue University</a>
		</p>
	</div>
</footer>