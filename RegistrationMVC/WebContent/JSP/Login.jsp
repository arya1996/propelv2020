<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Login</title>
	<style>
		body{
			padding-top: 10%;
			padding-left:35%;
			padding-right:35%;
			background-color: #008B8B;
		}
	</style>
</head>
<body>
	<form name="form" action="<%=request.getContextPath() %>/LoginServlet" method="post">	
		<center>
			<br><h1 style="color:#8B0000">Login</h1>
		</center>	
				Username:
				<input class="form-control" type="text" name="username" autocomplete="off" required>	
				Password:
				<input class="form-control" type="password" name="password" required>
				<span style="color: red"><%=(request.getAttribute("errMessage")==null)?"":request.getAttribute("errMessage")%></span>
				<br><input class="btn btn-danger" type="submit" value="Login">
				<input class="btn btn-primary" type="reset" value="Reset">		
	</form>
</body>
</html>