<%@page import="com.OnlineShopping.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%User u=(User)session.getAttribute("u"); %>
	<form action="UserServlet" method="post">
	<input type="hidden" name="action" value="updateUser">
		<table cellpadding="10" cellspacing="10" border="2" align="center">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="<%=u.getName()%>"></td>
			</tr>


			<tr>
				<td>Contact</td>
				<td><input type="text" name="contact" value="<%=u.getContact()%>"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="<%=u.getEmail()%>"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="text" name="pass" value="<%=u.getPass()%>"></td>
			</tr>

			<tr>
				<td><input type="submit" value="update"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>

		</table>
	</form>
</body>
</html>