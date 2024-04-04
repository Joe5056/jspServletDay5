<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>response</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	${userDTO}
	<h2>Congratulations!! You have successfully logged in</h2>
	<!-- To get data -->
	<h3>data</h3>
	<table class="table table-hover" style="width: 50%">
		<thead>
			<tr>
				<th>UserName</th>
				<th>Password</th>
				<th>Full Name</th>
				<th>Designation</th>
				<th>Salary
			</tr>

		</thead>
		<tbody>
			<tr>
				<td>${userDTO.username}</td>
				<td>${userDTO.password}</td>
				<td>${userDTO.fullname}</td>
				<td>${userDTO.designation}</td>
				<td>${userDTO.salary}</td>
			</tr>
		</tbody>
	</table>
	<a href="getAllRecords">click here to fetch all records</a>
</body>
</html>