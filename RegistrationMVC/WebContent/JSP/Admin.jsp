<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="arya"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Admin: User Registration</title>
<script>
	function validate(){
		
		var fullName=document.form.fullname.value;
		var email=document.form.email.value;
		var userName=document.form.username.value;
		var password=document.form.password.value;
		var conpassword=document.form.conpassword.value;
		
		if(fullName==null || fullName==""){
			alert("Full Name can't be blank");
		}else if(email==null || email==""){
			alert("Email can't be blank");
			return false;
		}else if(userName==null || userName==""){
			alert("userName can't be blank");
			return false;
		}else if(password.length<6){
			alert("Password must be atleast 6 characters long");
			return false;
		}else if(password!=conpassword){
			alert("Confirm Password should match with the Password");
			return false;
		}
	}
</script>
</head>
	<%
		if((request.getSession(false).getAttribute("Admin")==null)){
	%>
		<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
	<%} %>
<body>	
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color:#C71585">
				<div>
					<a href="" class="navbar-brand"> UserManagementApp </a>
				</div>
	
				<nav class="navbar navbar-expand-md navbar-dark">
					<div><a href="<%=request.getContextPath()%>/list"
						class="navbar-brand">Users</a></div>
				
		</nav>
	</header>
	<br>
	<center>
		<b><h2>Registration Application using MVC and ORACLE</b></h2>
	</center>
	<div font-size=10%;>
	<b>Welcome <b><%=session.getAttribute("Admin")%></b>
	</div>
	<div style="padding-left: 80%;padding-right:10%">
		<a class="list-group-item list-group-item-danger"  href="<%=request.getContextPath() %>/LogoutServlet">Logout</a>
	</div>
	<hr>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<arya:if test="${user != null}">
					<form action="update" method="post">
				</arya:if>
				<arya:if test="${user == null}">
					<form action="insert" method="post" onsubmit="return validate()">
				</arya:if>

				<caption>
					<h2>
					<arya:if test="${user != null}">
            			Edit User
            		</arya:if>
					
					<arya:if test="${user == null}">
            			Add New User
            		</arya:if>
					</h2>
				</caption>

				<arya:if test="${user != null}">
					<input type="hidden" name="id" value="<arya:out value='${user.id}'/>" />
				</arya:if>
	
				<fieldset class="form-group">
					<label>Full Name</label> <input type="text"
						value="<arya:out value='${user.fullName}' />" class="form-control"
						name="fullName" required placeholder="Enter full name" required>
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<arya:out value='${user.email}' />" class="form-control"
						name="email" placeholder="Enter email" required>
				</fieldset>

				<fieldset class="form-group">
					<label>UserName</label> <input type="text"
						value="<arya:out value='${user.userName}' />" class="form-control"
						name="userName" placeholder="Enter username" required>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						value="<arya:out value='${user.password}' />" class="form-control"
						name="password" placeholder="Enter password" required>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Date</label> <input type="date"
						value="<arya:out value='${user.date}' />" class="form-control"
						name="date" required>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Gender</label> <input type="radio" name="gender" value="Female">Female
					<input type="radio" name="gender" value="Male">Male
					<input type="radio" name="gender" value="other">Other			
				</fieldset>
				
				<fieldset class="form-group">
					<label>IsActive</label> <input type="checkbox" value="Y"  name="status"
						  required>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Role</label> <select name="role" required>
					<option>--select--</option>
						<option>Admin</option>
						<option>Editor</option>
						<option>User</option>
					</select> 
				</fieldset>

				<input  type="submit" class="btn btn-primary" value="Register">
				<input type="reset" class="btn btn-primary" value="Reset">
				</form>
			</div>
		</div>
	</div>
</body>
</html>