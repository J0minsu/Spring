<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/dotranscript" modelAttribute="transcript">

		<table class="formtable">
			<tr>
				<td class="label">Subject:</td>
				<td><sf:input class="control" type="text" path="subject" /> </br>
				<sf:errors path="subject" class="error" /> </td>
			</tr>
			<tr>
				<td class="label">Year:</td>
				<td><sf:input class="control" type="number" path="year" value="2019"/> </br>
				<sf:errors path="year" class="error" /> </td>
			</tr>
			<tr>
				<td class="label">Semester:</td>
				<td><sf:input class="control" type="number" path="semester" value="2"/> </br>
				<sf:errors path="semester" class="error" /> </td>
			</tr>
			<tr>
				<td class="label">Code:</td>
				<td><sf:input class="control" type="text" path="code" /> </br>
				<sf:errors path="code" class="error" /> </td>
			</tr>
			<tr>
				<td class="label">Score:</td>
				<td><sf:input class="control" type="number" path="score" min="2" max="3" /> </br>
				<sf:errors path="score" class="error" /> </td></td>
			</tr>
			<tr>
				<td class="label">Type:</td>
				<td><sf:input class="control" type="text" path="type" /> </br>
				<sf:errors path="type" class="error" /> </td></td>
			</tr>
			<tr>
				<td class="label">Grade:</td>
				<td><sf:input class="control" type="text" path="grade" /> </br>
				<sf:errors path="grade" class="error" /> </td></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="control" type="submit" value="수강 신청" /></td>
			</tr>
		</table>

	</sf:form>
</body>
</html>