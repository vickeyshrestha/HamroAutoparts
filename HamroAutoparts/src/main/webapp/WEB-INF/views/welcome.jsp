<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
<style>
.button {
	background-color: #4CAF50;
	border: thick;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>

</head>
<body>



	<section>
		<div class="jumbotron" style="background-color: #FE642E;">
			<div class="container">
				<img
					src="<c:url value="/resource/images/pageComponents/welcome1.png"/>"
					style="width: 400px; height: 250px" align="right">
				<h1 style="color: blue;" align="center">
					<b>${greeting}</b>
				</h1>
				<p align="center">
					<b>${tagline}</b>
				</p>
				<p align="center">
					5402 Renwick Dr<br> Houston, TX<br> Ph:682-556-9321
				</p>
			</div>
		</div>
	</section>


	<img
		src="<c:url value="/resource/images/pageComponents/japanese.png"/>"
		style="width: 580px; height: 258px" align="left">
	<img
		src="<c:url value="/resource/images/pageComponents/american.png"/>"
		style="width: 580px; height: 258px" align="right">
	<form action="login">
		<button class="button" type="submit" value="Submit">Login</button>
	</form>

</body>
</html>