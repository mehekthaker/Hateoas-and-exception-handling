<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div align="center">
<table>
	<tr><td><a href="/addCustomer">Add new Customer</a></td></tr>
	<tr><td><a href="/viewAllCustomers">View All Customers</a></td></tr>
	<tr><td><a href="/customer/{customerId}">View One Customers</a></td></tr>
	<tr><td><a href="/updateCustomer">Update Customer</a></td></tr>
	<tr><td><a href="/deleteCustomer">Delete Customer</a></td></tr>
</table>
</div>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>