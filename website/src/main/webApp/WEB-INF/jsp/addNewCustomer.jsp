<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MM Bank</title>
<style>body {
	background-color: lightsalmon;
}</style>
</head>
<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>

<div align="center">
<h3>Enter Account Holder Details</h3>
<form id="basic" method="post" action="/addCustomer">
<table>
<tr><td>Id: </td><td><input type="number" name="customerId" required="required"></td></tr>
<tr><td>Name:</td><td> <input type="text" name="customerName" required="required"></td></tr>
<tr><td>Contact Number: </td><td><input type="tel" name="contactNumber" min=10 max=10 required="required"></td></tr>
<tr><td>Email-id: </td><td><input type="email" name="emailId" required="required"></td></tr> 
<tr><td>Date of Birth:	</td><td><input type="date" name="dateOfBirth" required="required"></td></tr>
</table>
</form>
</div>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>

</html>