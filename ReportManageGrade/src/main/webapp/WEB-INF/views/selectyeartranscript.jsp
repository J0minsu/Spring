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
				<th>수 강 년 도</th><th>  학  기  </th><th>과 목 코 드</th><th> 과 목 명 </th><th>  구  분  </th><th>  학  점  </th>
			</tr>
		</thead>
      
		<tbody>
			<tr><h1>${selectYear} 년  ${selectSemester} 학기의 수강정보 </h1></tr>
			<c:forEach var="transcript" items="${transcripts}">
				<tr>
					<td>${transcript.year}</td><td>${transcript.semester}</td><td>${transcript.code}</td><td>${transcript.subject}</td><td>${transcript.type}</td><td>${transcript.score}</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</body>
</html>