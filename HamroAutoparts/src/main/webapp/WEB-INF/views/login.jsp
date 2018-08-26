<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
		<title>Login</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Please log in</h1>
				</div>
			</div>
		</section>
		
		<div class="container">
			<div class="row" ng-app="">
				<div class="alert alert-danger"><h3 align="center" style="color: blue;">Entering as<br> <strong><font face="verdana" color="green">{{j_username}}</font></strong></h3></div><br>
				<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
					
					
					<!-- Test for empty -->
					<c:if test="${not empty error}">
						<div class="alert alert-danger">
							<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
						</div>
					</c:if>
					
					
					<!-- Now ask username and password and design submit button-->
					<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
						
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="User Name" name='j_username' type="text" ng-model="j_username">
							</div>
							
							<div class="form-group">
								<input class="form-control" placeholder="Password" name='j_password' type="password" value="">
							</div>
							
							<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
