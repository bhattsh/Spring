<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Form</title>
</head>
<body>
	<form action="withdraw">
		<label>Enter Account Number<input type = "number" name ="accountNumber"></label><br>
		<label>Type Of  Account<input type = "radio" name ="accountType" value="SA">Saving
								<input type ="radio" name ="accountType" value="CA">Current
		</label>
		<br>
			<label>Enter Amount<input type = "number" name ="amount"></label><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>