<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customer</title>
</head>
<body>
			<div id="wrapper">
					<div id ="header">
						<h2> CRM- CUSTOMER RELATIONSHIP MANAGER</h2>
					</div>
			</div>
<div id ="container">
	<div id ="content">
	<!-- table here -->
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>

	<!--  looop over customer -->	
	
	<c:forEach var="tempCustomer" items="${customer}">
		<tr>
		<td>${tempCustomer.firstName}</td>
		<td>${tempCustomer.lastName}</td>
		<td>${tempCustomer.email}</td>
		</tr>
	</c:forEach>

	</table>
	
	</div>

</div>
	
</body>
</html>