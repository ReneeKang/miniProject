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

<style type="text/css">

#subjectA:link{color: black; text-decoration: none;}
#subjectA:visited{color: black; text-decoration: none;}
#subjectA:hover {color:pink; text-decoration: underline;}
#subjectA:active{color: black; text-decoration: none;}



h2{
	margin:50px 13px;
}
table{
	
	<%-- border: 1px solid #444444;
	 border-collapse: collapse; 
	--%>
}

th{
	font-size:17px;
	<%--border: 1px solid gray;--%>
	width : 200px;
	padding:10px 20px;
}

td{
	color:gray;
	text-align: center;
	<%--border: 1px solid gray;--%>
}

.board-container{
	margin: 80px auto;
}

.board-title-date{
	width:150px;
}


#currentPaging{
	color: red;
	text-decoration:underline;
}

#paging{
	color: black;
	text-decoration:none;
}

</style>
</head>
<body>
	<h2>게시글 목록</h2> 
	
	<% System.out.println("boardList페이지"); 
	
	
	%>
	<%-- 값넘어오나 확인 = ${list}  --%>
	
	
	
	
	
<div class="board-container">	
	<table border=1 frame="hsides" rules="rows">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th class="board-title-date">작성일</th>
			<th>조회수</th>
		</tr>
		
	<c:if test="${requestScope.list != null}"> <%-- list값 null인지 체크해보기!!!! --%>
		
		<c:forEach var="boardDTO" items="${list}"> <%-- items="${requestScope.list} --%>
			<tr>
				<td>${boardDTO.seq}</td> <%--${boardDTO.getSeq()}      ~~=변수=값&변수=값  seq 랑 pg들고가자--%>
				<td ><a id="subjectA" href="/miniProject/board/boardContent.do?seq=${boardDTO.seq}&pg=${pg}"> my : ${boardDTO.subject}</a>
					<br>
					<a id="subjectA" href="/miniProject/board/boardView.do?seq=${boardDTO.seq}&pg=${pg}"> t :${boardDTO.subject}</a>
				</td>																		<%--${param.pg } --%>
				<td>${boardDTO.name}</td>
				<td>										
				<fmt:formatDate value="${boardDTO.logtime}" pattern="yyyy.MM.dd" type="date"/> 
				</td>
				<td>${boardDTO.hit}</td>
			</tr>
		</c:forEach>
		
	</c:if>
	
	
	</table>
	
	


	<div style="float:left; text-align:center; width:70px;">
	<input type="button" value="글쓰기" style="margin:5px;" onclick="location.href='/miniProject/board/boardWriteForm.do'">
	</div>	
<div style="float:left; text-align:center; width:800px;">
	<c:forEach var="i" begin="1" end="${requestScope.totalP }" step="1">
	<%-- 
	[ <a href="/mvcBoard/board/boardList.do?pg=${i}">${i }</a>] &nbsp;
	 --%>	
		<%-- 현재페이지라면 빨간색 아님 검정색 ㅋ  --%>
		
		<c:if test="${i ==pg}">
			[ <a href="/miniProject/board/boardList.do?pg=${i}"  id="currentPaging">${i }</a>] &nbsp;
		</c:if>
		<c:if test="${i !=pg}">
			[ <a href="/miniProject/board/boardList.do?pg=${i}" id="paging">${i }</a>] &nbsp;
		</c:if>
		
	</c:forEach>

	</div>
</div>	

</body>
</html>