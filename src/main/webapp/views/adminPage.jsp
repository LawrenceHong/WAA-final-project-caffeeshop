<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	products:
	<br />
	<input type="button"  value="Create" onClick="location='/admin/createProduct'">
	<br />
	<input type="button"  value="List" onClick="location='/admin/listProducts'">
	<br />
	<br /> 
	persons:
	<br />
	<input type="button"  value="Create" onClick="location='/admin/createPerson'">
	<br />
	<input type="button"  value="List" onClick="location='/admin/listPersons'">
	<br />
	<br />
	Users:
	<br />
	<input type="button"  value="CreateUser" onClick="location='/admin/createUser'">
	<br />
	<br /> 
	orders:
	<br />
	<input type="button"  value="List orders" onClick="location='/admin/listOrder'">
	<br />
	<br />
	<a href="/login">logout</a>
</body>
</html>