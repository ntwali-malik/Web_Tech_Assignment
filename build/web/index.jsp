<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees Example</title>
</head>
<body>
<a href = "/StudentAdmissionModule/stud?action=new">New Register</a>
<table align="center" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Faculty</th>
			<th>Department</th>
                        <th>Action</th>
                        
		</tr>
		
		<c:forEach items="${students }" var="stud">
			<tr>
				<td>${stud.studentId }</td>
				<td>${stud.name }</td>
				<td>${stud.email }</td>
				<td>${stud.faculty }</td>
				<td>${stud.department }</td>
                                
				<td><a href = "/StudentAdmissionModule/stud?action=update&id=${stud.studentId }">Update</a></td>
				<td><a href = "/StudentAdmissionModule/stud?action=delete&id=${stud.studentId}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>