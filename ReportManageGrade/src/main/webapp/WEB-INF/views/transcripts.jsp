<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		width: 100%;
		border-top: 1px solid #444444;
		border-collapse: collapse;
	}
	
	th, td {
		border-bottom: 1px solid #444444;
		padding: 10px;
		text-align:center
	}
	</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>  년  도  </th><th>  학  기  </th><th>이 수 학 점</th><th>  상 세 보 기  </th>
			</tr>
		</thead>
      
		<tbody>
			<c:forEach var="transcript" items="${transcripts}">
				<tr>
					<td>${transcript.year}</td><td>${transcript.semester}</td><td>${transcript.sum}</td><td><a href="${pageContext.request.contextPath}/getchoicesemestertranscripts?year=${transcript.year}&semester=${transcript.semester}"> 자세히 보기</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>