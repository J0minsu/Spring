<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${transcript.year }년 ${transcript.semester }학기 ${transcript.subject } 과목 수강신청 성공 </br>

<a href="${pageContext.request.contextPath}/transcripts"> click here to view current transcripts</a>
</body>
</html>