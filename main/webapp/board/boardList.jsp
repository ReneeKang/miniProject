<%@page import="org.apache.catalina.users.SparseUserDatabase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">

#subjectA:link{color: black; text-decoration: none;}
#subjectA:visited{color: black; text-decoration: none;}
#subjectA:hover {color:black; font-weight:bold; text-decoration: underline;}
#subjectA:active{color: black; text-decoration: none;}



h2{
	margin:50px 13px;
	
}
table{
	
	<%-- border: 1px solid #444444;
	 border-collapse: collapse; 
	--%>
	text-align: center; 
}

.board-title th{
	
	font-size:18px;
	border:hidden;

	<%--border: 1px solid gray;--%>
	width : 200px;
	/* padding:10px 20px; */ 
}

td{
	height:50px;
	color:gray;
	<%--border: 1px solid gray;--%>
}

.board-container{
	margin: 30px auto;
}
.board-title{
	background-color: #FCDC4D;

	height:50px;
}

.board-title-date{
	width:150px;
}

/* 
#currentPaging{
	color: red;
	text-decoration:underline;
}
 */
#paging{
	color: black;
	text-decoration:none;
}
.board-list-item:hover{
	background-color: #FCDC4D;
}
.pageblock{
	display:flex;
	justify-content: center;
	margin-top:20px;
}
  
.wbtn{
	padding-top: 10px;
	padding-left: 15px;
}
</style>

		
		
</head>

	<h2>게시글 목록</h2> 
	
	<% System.out.println("boardList페이지"); 
	
	
	%>
	<%-- 값넘어오나 확인 = ${list}  ${sessionScope.userEmail }--%>
	
	
	
<body>	
	
<div class="board-container">	
	
	
	<table border=1 frame="hsides" rules="rows" width="95%" >
		<tr class="board-title">
			<th>글번호</th>
			<th >제목</th>
			<th>작성자</th>
			<th class="board-title-date">작성일</th>
			<th>조회수</th>
		</tr>
		
	<c:if test="${requestScope.list != null}"> <%-- list값 null인지 체크해보기!!!! --%>
		
		<c:forEach var="boardDTO" items="${list}"> <%-- items="${requestScope.list} --%>
			<tr class="board-list-item">
				<td>${boardDTO.seq}</td> <%--${boardDTO.getSeq()}      ~~=변수=값&변수=값  seq 랑 pg들고가자--%>
				<td align="left" >
<%-- 					<a id="subjectA" onclick="isLogin()"  href="/miniProject/board/boardView.do?seq=${boardDTO.seq}&pg=${pg}">${boardDTO.subject}</a> --%>
					<a id="subjectA" onclick="isLogin(${boardDTO.seq})"  href="#">
						<c:forEach var="i" begin="1" end="${boardDTO.lev}" step="1">
							&emsp;	
						</c:forEach>
					
					<c:if test="${boardDTO.pseq!=0}"> 
						<img src="../image/reply-cursor.gif" alt="답글화살표">
					</c:if>
					${boardDTO.subject}</a>
				</td>																		<%--${param.pg } --%>
				<td><%-- ${boardDTO.name} --%>${boardDTO.email}</td>
				<td>										
				<fmt:formatDate value="${boardDTO.logtime}" pattern="yyyy.MM.dd" type="date"/> 
				</td>
				<td>${boardDTO.hit}</td>
			</tr>
		</c:forEach>
		
	</c:if>
	
	
	</table>
	
	<div class="wbtn" style="float:left; text-align:center;">
		<input type="button" value="글쓰기" style="margin:5px;" onclick="location.href='/miniProject/board/boardWriteForm.do'">
	</div>
	
<div class="paging-line">


	
	<div class="pageblock" style="float:left; text-align:center; width:800px;">
	
	
		<ul class="pagination">
		
		<c:forEach var="i" begin="1" end="${requestScope.totalP }" step="1">
		<%-- 
		[ <a href="/mvcBoard/board/boardList.do?pg=${i}">${i }</a>] &nbsp;
		 --%>	
			<%-- 현재페이지라면 빨간색 아님 검정색 ㅋ  --%>
			
			<c:if test="${i ==pg}">
				<li class="page-item active"><a class="page-link" href="/miniProject/board/boardList.do?pg=${i}"  id="currentPaging">${i }</a></li>
			</c:if>
			<c:if test="${i !=pg}">
				<li class="page-item"><a class="page-link" href="/miniProject/board/boardList.do?pg=${i}" id="paging">${i }</a></li>
			</c:if>
		</c:forEach>
		
		</ul>
	</div>
	
	</div>
	
</div>	


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript">		
function isLogin(seq){
	if(${empty memId}){
		alert("먼저 로그인하세요");
	}else{													
		location.href="/miniProject/board/boardView.do?seq="+seq+"&pg=${requestScope.pg}";
	}	
}
</script>
		
</body>
</html>