<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="arya"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #00695C">
				<div>
					<a href="" class="navbar-brand"> User Registration </a>
				</div>
	
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/list"
						class="nav-link">Users</a></li>
				</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-secondary">Add
						New User</a>
			</div>
			<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>SLNO</th>
							<th>FULL NAME</th>
							<th>Email</th>
							<th>USERNAME</th>
							<th>PASSWORD</th>
							<th>STATUS</th>
							<th>ROLE</th>
							<th>GENDER</th>
							<th>DATE</th>
							<th>ACTIONS</th>
						</tr>
					</thead>
				<tbody>
				<arya:forEach var="user" items="${listUser}">
				<tr>
				<td><arya:out value="${user.id}"/></td>
				<td><arya:out value="${user.fullName}"/></td>
				<td><arya:out value="${user.email}"/></td>
				<td><arya:out value="${user.userName}"/></td>
				<td><arya:out value="${user.password}"/></td>
				<td><arya:out value="${user.active}"/></td>
				<td><arya:out value="${user.roleId}"/></td>
				<td><arya:out value="${user.gender}"/></td>
				<td><arya:out value="${user.date}"/></td>
				<td><a href="edit?id=<arya:out value='${user.id}' />">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; 
				<a href="delete?id=<arya:out value='${user.id}' />">Delete</a></td>
				</tr>
				</arya:forEach>
				</tbody>
				</table>
			</div>	
	</div>
</body>
</html>