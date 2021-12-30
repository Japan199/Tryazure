<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="home.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
	
</head>
<body>
	<div class="container text-center">
		<div><h1>All Users</h1></div>
		<div>
			
			
		</div>
		<div>
			<table class="table table-striped table-bordered">
				
				<thead class="thead-dark"></thead>
					<tr>
						<th>User Id</th>
						<th>Email</th>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
					<c:forEach var="user" items="${userList}" varStatus="status">
						<tr>
							<td>${user.id}</td>
							<td>${user.email}</td>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
						</tr>
					</c:forEach>
			</table>
		</div>
		
		
	</div>
	
	
	
</body>
</html>