<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<h1>This is login page</h1>
	<h1>
		<%
			out.println(request.getAttribute("greeting"));
		%>
	</h1>

	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null)
			out.println(msg);
	%>

	<form action="/LoginRegister/loginServ" method="POST">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password">
				</td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>