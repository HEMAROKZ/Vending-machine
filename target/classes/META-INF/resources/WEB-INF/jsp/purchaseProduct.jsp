<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./Base.jsp"%>
<title>Vending Machine Product List</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>

<body>
<div style="font-family: sans-serif; font-size: 22px ; background-color: black; height: 30px; text-align: center; color: white">Vending Machine Product List For Purchase
</div>
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: black; height: 80px;">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/home"
					style="font-family: sans-serif; font-size: 22px">Home <span
						class="sr-only">(current)</span></a></li>
			</ul>
		</div>
	</nav>
	<fieldset>
		<table class="table" border="2"
			style="margin-top: 25px; text-align: center">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Product Id</th>
					<th scope="col">Name</th>
					<th scope="col">Product Price</th>
					<th scope="col">product InventryCount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="l" items="${list}">
					<tr>
						<td>${l.productId}</td>
						<td>${l.name}</td>
						<td>${l.productPrice}</td>
						<td>${l.productInventryCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
        	<a href="/purchaseproductpage" style="font-size: 20px">Purchase Item</a>
			<a href="/home" class="btn btn-outline-warning">Go Back</a>
					</div>
	</fieldset>
</body>
</html>