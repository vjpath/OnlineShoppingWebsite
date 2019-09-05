<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ProductServlet" method="post">
	
		<table cellpadding="10" cellspacing="10" border="2" align="center">
			<tr>
				<td>Product_name</td>
				<td><input type="text" name="pname"></td>
			</tr>


			<tr>
				<td>Category</td>
				<td><select name="Category">
					<option value="cloth">Clothes</option>
					<option value="cloth">Shoes</option>
					<option value="cloth">Glasses</option>
					
				</select></td>
			</tr>

			<tr>
				<td>Quantity</td>
				<td><input type="text" name="qty"></td>
			</tr>

			<tr>
				<td>Price</td>
				<td><input type="text" name="price"></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><input type="text" name="Des"></td>
			</tr>

			<tr>
				<td colspan="2"><center><input type="submit" value="Save"></center></td>
				
			</tr>

		</table>
	</form>
</body>
</html>