<%@page import="org.apache.catalina.users.SparseUserDatabase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

h2{
	margin:50px 13px;
}
table{
	 border: 1px solid #444444;
	 border-collapse: collapse;
	 
}

th{
	font-size:17px;
	border: 1px solid gray;
	width : 80px;
	padding:10px 20px;

}

td{
	color:gray;
	text-align: center;
	border: 1px solid gray;
}


.board-title-date{
	width:150px;
}


</style>
</head>
<body>
	<h2>게시글 목록2</h2> 
	
	<% System.out.println("boardList페이지"); %>
	<%--EL로확인 = ${list}  --%>
	
	
	
	 <div class="board-container">	
	<table class="table-list">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
			<th class="board-title-date">작성일</th>
		</tr>
		
		<c:forEach var="boardDTO" items="${list}">
			<tr>
				<td>${boardDTO.seq}</td>
				<td>${boardDTO.name}</td>
				<td>${boardDTO.subject}</td>
				<td>${boardDTO.hit}</td>
				<td>										
				<fmt:formatDate value="${boardDTO.logtime}" pattern="yyyy.MM.dd" type="date"/> 
				</td>
			</tr>
		</c:forEach>
	
	</table>
	
</div>		
		
				

	<%--	
	
	.board-title-content{
	width:250px;
}


 <div class="board-container">	
	<table>
		<tr>
			<th>글번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>제목</th>
			<th class="board-title-content">내용</th>
			<th>그룹번호</th>
			<th>단계</th>
			<th>글순서</th>
			<th>원글번호</th>
			<th>답변수</th>
			<th>조회수</th>
			<th class="board-title-date">날짜</th>
		</tr>
		
		<c:forEach var="boardDTO" items="${list}">
			<tr>
				<td>${boardDTO.seq}</td>
				<td>${boardDTO.id} </td>
				<td>${boardDTO.name}</td>
				<td>${boardDTO.email}</td>
				<td>${boardDTO.subject}</td>
				<td>${boardDTO.content} </td>
				<td>${boardDTO.ref}</td>
				<td>${boardDTO.lev} </td>
				<td>${boardDTO.step}</td>
				<td>${boardDTO.pseq} </td> 
				<td>${boardDTO.reply}</td>
				<td>${boardDTO.hit}</td>
				<td>										
				<fmt:formatDate value="${boardDTO.logtime}" pattern="yyyy.MM.dd" type="date"/> 
				</td>
			</tr>
		</c:forEach>
	
	</table>
	
</div>		
		
	 --%>
	
	
	

	
</body>
</html>