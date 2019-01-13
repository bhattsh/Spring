<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="createCurrentAccount">
		<label>Account Holder Name<input type = "text" name ="accountHolderName"></label><br>
		<label>Enter Initial Balance<input type = "number" name ="accountBalance"></label><br>
		<label>Over Draft Limit<input type = "number" name ="odLimit">
		</label>
		<input type="submit" value="submit">
	</form>
</body>
</html>