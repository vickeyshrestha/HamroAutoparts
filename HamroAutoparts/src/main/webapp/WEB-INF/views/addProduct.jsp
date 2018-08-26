<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="alert alert-info">
			<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">logout</a>
			<div class="pull-right" style="padding-right:50px">
				<a href="?language=en">English</a>|<a href="?language=nl">Dutch</a>
			</div>
				<h1>Auto Products</h1>
				<p>Add products</p>
				<p id="demo"></p>
			</div>
		</div>
	</section>
	
	<form:form method = "GET" action = "/HamroAutoparts/products">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "View current products"/>
               </td>
            </tr>
         </table>  
      </form:form>
	

	
	<section class="container">
	<!-- ===================================START FORM=============================================================== -->
		<form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
		<form:errors path="*" cssClass="alert alert-danger"	element="div"/> 		<%-- For validation--%>
			<fieldset>
				<legend>Add new product</legend>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<!-- Instead of straight writing a label, we will pull from properties file 
						----------------------------------------------------------------------------->
						<spring:message code="addProduct.form.productId.label"/>	
					</label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text" class="form:input-large"/>
<%-- For validation--%>	<form:errors path="productId" cssClass="text-danger"/> 
					</div>
				</div>
									
					
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">
<!-- Label NAME-->		<spring:message code="addProduct.form.name.label"/>	
					</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitPrice">
<!-- Label unitPrice-->		<spring:message code="addProduct.form.unitPrice.label"/>	
					</label>
					<div class="col-lg-10">
						<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
						<form:errors path="unitPrice" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="manufacturer">
<!-- Label manufacturer-->		<spring:message code="addProduct.form.manufacturer.label"/>					
					</label>
					<div class="col-lg-10">
						<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
						<form:errors path="manufacturer" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="category">
<!-- Label category-->		<spring:message code="addProduct.form.category.label"/>	
					</label>
					<div class="col-lg-10">
						<form:input id="category" path="category" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
<!-- Label unitsInStock-->		<spring:message code="addProduct.form.unitsInStock.label"/>	
					</label>
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
					</div>
				</div>
				
					
				<div class="form-group">
					<label class="control-label col-lg-2" for="description">
<!-- Label description-->		<spring:message code="addProduct.form.description.label"/>	
					</label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows = "2"/>
					</div>
				</div>
				
						
				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">
<!-- Label condition-->		<spring:message code="addProduct.form.condition.label"/>	
					</label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />New
						<form:radiobutton path="condition" value="Old" />Old
						<form:radiobutton path="condition" value="Refurbished" />Refurbished
					</div> 
				</div>
				
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="productImage">
<!--  Label image -->		<spring:message code="addProdcut.form.productImage.label"/>
					</label>
					<div class="col-lg-10">
						<form:input id="productImage" path="productImage" type="file" class="form:input-large" />
					</div>
				</div>

				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
			</fieldset>
		</form:form>
		<!-- ========================================End form=================================================== -->
	</section>
</body>