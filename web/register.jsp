<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Register</title>
</head>
<body>

	<h1>Student CRUD</h1>

	<form action="/StudentAdmissionModule/stud" method="post">
		<table align="center">

			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${student.name }"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${student.email }"></td>
			</tr>
			<tr>
				<td>Faculty</td>
				<td><input type="text" name="faculty" value="${student.faculty }"></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><input type="text" name="department" value="${student.department }"></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" value="new" name="action">
					<input type="hidden" value="${student.studentId}" name="studentId">
				</td>
				<td><input type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form>
</body>
</html>