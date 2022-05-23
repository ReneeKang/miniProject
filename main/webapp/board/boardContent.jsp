<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
pre{
	white-space: pre-wrap; /* pre tag내에 word wrap */

}
</style>
</head>
	
	<table border="1" >
		<tr >
			<td width="500" height="300">
				<pre>${requestScope.content} </pre>
			</td>
		</tr>
		<tr >
			<td align="center">
			
				<button type="button">수정</button>
				<%--<a href="/mvcBoard/board/boardList.do"><button type="button">돌아가기</button></a> --%>
				<a href="/miniProject/board/boardList.do?pg=${param.pg }"><button type="button">목록 돌아가기</button></a>
			</td>
		</tr>
	</table>
	

<%-- seq가져와야해 이거 어떻게 ? --%>