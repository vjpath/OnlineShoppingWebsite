<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserServlet" method="post">
	<input type="hidden" name="action" value="addUser">
		<table cellpadding="10" cellspacing="10" border="2" align="center">
			<tr>
				<td>Name</td>
				<td><input type="text" placeholder="Enter your name" name="name" required></td>
			</tr>


			<tr>
				<td>Contact</td>
				<td><input type="text" placeholder="Enter your phone no" name="contact" required></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" placeholder="Enter your Email id" name="email" required></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="text" placeholder="Enter your Password" name="pass" required></td>
			</tr>

			<tr>
				<td>Confirm Password</td>
				<td><input type="text" placeholder="Confirm your password" name="cpass" required></td>
			</tr>

			<tr>
				<td><input type="submit" value="Save"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>

		</table>
	</form>
</body>
</html>