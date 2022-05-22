<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.boardViewBox{

}

table{
	margin:100px auto;
}
pre{
	height:300px;
	
	/* white-space: pre-wrap;  *//* pre tag내에 word wrap */
	white-space: pre-line;
}

btn1, btn2{
	margin:10px auto;
}
</style>
</head>
<body>
	
	
	<table width="1000px" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<td colspan="3">
				<h2>${boardDTO.subject }</h2>
			</td>
		</tr>
		<tr >
			<td width="150" > 글번호 : 
				${boardDTO.seq} 
			</td>
			<td width="150" >작성자 :
				${boardDTO.id} 
			</td>
			<td width="150" >조회수 :
				${boardDTO.hit} 
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<div class="boardViewBox" >
					<pre >${boardDTO.content }</pre>  <%--내가 입력한 그대로 화면에 뿌려라 --%>
				</div>
			</td>
		</tr>
		
		<tr >
			<td colspan="3" align="center">
			
				<button class="btn1" type="button">수정</button>
				<button class="btn2" type="button" style="margin:5px;" onclick="location.href='/miniProject/board/boardList.do?pg=${pg }'">목록</button>
				
			</td>
		</tr>
	</table>
	
	
	
</body>
</html>
<%-- seq가져와야해 이거 어떻게 ? --%>