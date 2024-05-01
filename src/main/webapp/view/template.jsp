<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Novel 101 - 당신의 이야기를 들려주세요</title>
<script src="../js/jquery-3.7.1.js"></script>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="components/header.jsp" />
	
	<main>
		<jsp:include page="${incUrl}"/>
	</main>
	
	<jsp:include page="components/footer.jsp" />
</body>
</html>