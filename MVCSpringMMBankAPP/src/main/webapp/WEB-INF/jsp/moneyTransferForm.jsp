<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="transferMoney">
		
		<label>Sender's Account Number<input type = "number" name ="senderAccountNumber"></label><br>
		<label>Type Of  Account<input type = "radio" name ="accountType" value="SA">Saving
							<input type ="radio" name ="accountType" value="CA">Current
		</label>
		<br>
		<label>Receiver's Account Number<input type = "number" name ="receiverAccountNumber"></label><br>
		<label>Amount<input type = "number" name ="amount"></label><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>