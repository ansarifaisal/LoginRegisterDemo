<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>This is register page</h1>
	<form action="/LoginRegister/registerServ" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" id="username">
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="Register">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>