<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="/youtunes/store">YouTunes</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="store?action=showArtists">Artists</a></li>
					<li class="nav-item"><a class="nav-link" href="store?action=showAboutUs">About Us</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="store?action=showContactUs">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>