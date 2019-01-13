<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style>
		
		/* Dropdown Button */
		.dropbtn {
			background-color: #4CAF50;
			color: white;
			padding: 10px;
			font-size: 15px;
			border: none;
		}
		
		/* The container <div> - needed to position the dropdown content */
		.dropdown {
			position: relative;
			left:300px;
			display: inline-block;
		}
		
		/* Dropdown Content (Hidden by Default) */
		.dropdown-content {
			display: none;
			position: absolute;
			background-color: #f1f1f1;
			min-width: 160px;
			box-shadow: 0px 8px 10px 0px rgba(0, 0, 0, 0.2);
			z-index: 1;
		}
		
		/* Links inside the dropdown */
		.dropdown-content a {
			color: black;
			padding: 12px 16px;
			text-decoration: none;
			display: block;
		}
		
		/* Change color of dropdown links on hover */
		.dropdown-content a:hover {
			background-color: #ddd;
		}
		
		/* Show the dropdown menu on hover */
		.dropdown:hover .dropdown-content {
			display: block;
		}
		
		/* Change the background color of the dropdown button when the dropdown content is shown */
		.dropdown:hover .dropbtn {
			background-color: #3e8e41;
		}
</style>


</head>
<body>
<div class="dropdown">
	

			 <button class="dropbtn">CreateAccount</button>
			 	 <div class="dropdown-content">
					<a href="createSavingsAccountRequest">Create New Saving Account</a>
					<a href="createCurrentAccountRequest">Create New Current Account</a>
				</div>
</div>
			
	<ul>
		<li><a href="updateAccountRequest">Update Account</a></li>
		<li><a href="searchRequest">Search Account</a></li>
		<li><a href="closeAccountRequest">Close Account</a></li>
		<li><a href="withdrawRequest">Withdraw</a></li>
		<li><a href="depositRequest">Deposit</a></li>
		<li><a href="moneyTransferRequest">Fund Transfer</a></li>
		<li><a href="getAll">Get All Saving Accounts</a></li>
	</ul>
</body>
</html>