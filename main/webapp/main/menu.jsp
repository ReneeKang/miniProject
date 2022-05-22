<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<ul>
		<li>글쓰기</li>
		<li>목록</li>	
	</ul>
	
	
	
</body>
</html> --%>


<style>
.mainnav{
/* FFCB47 F3DE8A */
	background-color: #FFCB47;
	list-style : none;
	color: #ffff00;
}

.mainnav li{ /*후손관계*/
	display: inline-block;  /* inline은 span  block은 div 그래서 inline-block은 둘 섞어서 옆으로 가게 함 ㅋ*/
	justify-content: space-between;
}

.mainnav li a{
	color:#F1F2EB;
	padding: 0 13px; /*위/아래, 좌우*/
	background-color: black;
	font: bold 16px/40px 'Nanum Gothic', sans-serif;
	 /*  폰트의 굵기 | 글자의 크기 / line-height 줄 간격 | 글꼴 , 앞에글꼴 없으면 다음 글꼴(''는 이름입력시 중간 공백있어서 감싸준거임) */
	text-transform: uppercase;
	display:block;
	text-decoration:none;
}
li:hover{
	
	background: orange;
	
}
</style>

	
<ul class="mainnav">
	<li><a href="/miniProject/board/boardWriteForm.do">글쓰기</a></li>
	<li><a href="/miniProject/board/boardList.do?pg=1">목록</a></li>
</ul>

	
	
	
	
	
	
	
	
	
	
	
	
