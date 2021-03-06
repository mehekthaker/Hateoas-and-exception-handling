<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Customers</title>
<style>
body {
	background-color: #7fffda;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>

	<div align="center">

		<h1>Account Holder List</h1>
		<jstl:if test="${customer != null }">
			<table>
				<tr>
					<th>Customer ID</th>
					<th>Name</th>
					<th>Date of Birth</th>
					<th>Email ID</th>
					<th>Contact</th>
				</tr>

			</table>
		</jstl:if>
		<jstl:if test="${customer == null}">
			<h2>No customers found!</h2>
		</jstl:if>
	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

</body>
</html>