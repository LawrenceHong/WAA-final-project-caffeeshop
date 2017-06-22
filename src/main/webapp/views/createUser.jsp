<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="user" action="saveUser">	
    <table>
      <tr>
        <td><form:label path="username">userName:</form:label></td>
        <td><form:input path="username" /></td>
      </tr>
      <tr>
        <td><form:label path="password">password:</form:label></td>
        <td><form:input path="password" /></td>
      </tr>
      <tr>
        <td><form:label path="role">role:</form:label></td>
        <td><form:input path="role" /></td>
      </tr>
      <tr>
        <td><form:label path="enabled">enabled</form:label></td>
        <td><form:checkbox path="enabled" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="saveUser" /></td>
      </tr>
    </table>
    </form:form>
</body>
</html>