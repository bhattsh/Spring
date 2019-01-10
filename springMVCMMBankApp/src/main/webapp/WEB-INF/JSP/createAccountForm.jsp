<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="createSavingAccount">
		<label>Type Of  Account<input type = "radio" name ="accountType" value="SA">
							<input type ="radio" name ="accountType" value="CA">
		</label>
		<br>
		<label>Account Holder Name<input type = "text" name ="accountHolderName"></label><br>
		<label>Enter Initial Balance<input type = "number" name ="accountBalance"></label><br>
		<label>Salaried<input type = "radio" name ="salaried" value="yes">
							<input type ="radio" name ="salaried" value="no">
		</label>
		<input type="submit" value="submit">
	</form>
</body>
</html>