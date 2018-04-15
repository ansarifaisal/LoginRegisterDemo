<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Page</title>
</head>
<body>

	<h1>This is a reset page</h1>
	
	<form action="/LoginRegister/resetServ" method="POST">
		<table>
			<tr>
				<td colspan="1"><input type="hidden" name="username"
					value="<%=request.getParameter("username")%>"></td>
			</tr>
			<tr>
				<td>Old Password:</td>
				<td><input type="password" name="oldPassword" id="oldPassword"></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input type="password" name="newPassword" id="newPassword"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="Reset"></td>
			</tr>
		</table>
	</form>

</body>
</html>