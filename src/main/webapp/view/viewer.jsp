<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소설뷰어</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/maru-buri.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
</head>
<style>
/* 	*{
		font-family: 'MaruBuriExtraLight';
		font-family: 'MaruBuriLight';
		font-family: 'MaruBuri';
		font-family: 'MaruBuriBold';
		font-family: 'MaruBuriSemiBold';
	} */
	
	.viewerMain .textarea,
	.viewerMain .textarea b{
		font-family: 'MaruBuri';
	}
</style>
<script src="../js/jquery-3.7.1.js"></script>
<script>
	window.onload = function(){				
		const epiList = document.querySelector('.epiList');
		const epiBtn = document.getElementById('epiBtn');
		
		epiBtn.addEventListener('click', function() {
		    epiList.classList.toggle('active');
		    epiBtn.classList.toggle('active');
		});
		
		document.oncontextmenu = function(){return false;}
		document.onselectstart = function(){return false;}
	}
</script>
<body oncontextmenu="return false" onselectstart="return false">
	<jsp:include page="${incUrl}"/>
	
</body>
</html>