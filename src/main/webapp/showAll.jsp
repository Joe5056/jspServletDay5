<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AllRecords</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	${userDTO}
	<h2>Showing All Records...Next Page</h2>
	<!-- To get data -->
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
			<m:forEach items="${listofRecords}" var="tempoVar">
				<tr bgcolor="yellow">
					<td>${tempoVar.username}</td>
					<td>${tempoVar.password}</td>
					<td>${tempoVar.fullname}</td>
					<td>${tempoVar.designation}</td>
					<td>${tempoVar.salary}</td>
				</tr>
			</m:forEach>
		</tbody>

	</table>

</body>
</html>