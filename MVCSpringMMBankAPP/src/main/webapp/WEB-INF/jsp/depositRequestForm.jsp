<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Form</title>
</head>
<body>
	<form action="deposit">
	<label>Enter Account Number<input type = "number" name ="accountNumber"></label><br>
		<label>Type Of  Account<input type = "radio" name ="accountType" value="SA">
							<input type ="radio" name ="accountType" value="CA">
		</label>
		<br>
		<label>Enter Amount<input type = "number" name ="amount"></label><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>