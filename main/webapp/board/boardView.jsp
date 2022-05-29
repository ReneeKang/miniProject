<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	
	<form name="boardViewForm" action="#">
		<input type = "hidden" name="seq" value="${boardDTO.seq}">
		<input type = "hidden" name="pg" value="${pg}">
		<input type = "hidden" name="pseq" value="${boardDTO.pseq}"><!-- delete할때필요??reply? -->
		<input type = "hidden" name="subject" value="${boardDTO.subject}"><!-- 제목바꿔주려고 원 제목도.. -->
		
		<%-- <input type = "text" name="seq" value="${boardDTO.seq}">
		<input type = "text" name="pg" value="${pg}">
		 --%>
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
				<div class="boardViewBox" style="border:1px red solid; width:100%; height:100%; overflow:auto;">
					<pre style="white-space:pre-line;word-break; break-all;">
						${boardDTO.content }
					</pre>  <%--내가 입력한 그대로 화면에 뿌려라 --%>
				</div>
			</td>
		</tr>
		
		<tr >
			<td colspan="3" align="center">
			
				<%-- 
				<button class="btn2" type="button" style="margin:5px;" onclick="location.href='/miniProject/board/boardList.do?pg=${pg }'">목록</button>
				<button class="btn1" type="button" onclick="location.href='/miniProject/board/boardUpdateForm.do'">수정</button>
				<input type="button" value="글삭제 - 주말숙제 -seq들고가면 된다" onclick="location.href='/miniProject/board/boardList.do?pg=${pg }'">
				 --%>
				
				<button class="btn2" type="button" style="margin:5px;" onclick="location.href='/miniProject/board/boardList.do?pg=${pg }'">목록</button>
				
			<c:if test="${memId ==boardDTO.id }">
				<button class="btn1" type="button" onclick="mode(1)">글수정</button>
			
				<input type="button" value="글삭제" onclick="mode(2)">
			</c:if>
				<input type="button" value="답글" onclick="mode(3)">
			</td>
		</tr>
	</table>
	
	</form>
	<!--  글 삭제와 글 수정은 본인만 가능하도록 
	결과창에서 로긴하고 들어갔을때 내글이면  글수정 그런게 다 보여야한다ㅡ 근데 남의글이면
	글수정, 글 삭제 버튼 뜨지 않아야한다. -->
	
	<!-- 글 수정, 글 삭제 버튼은 본인의 글일때만 뜨게 한다. -->
	<input type="button" value="글 수정 - xx">  <!-- 글수정창 뜨고나서 수정들어가야함 -->
	<input type="button" value="글삭제 - 주말숙제 -seq들고가면 된다 -xx">
	<input type="button" value="답글-xxx">
	<!-- 보드dao mybatis로 바꾸고,    /   수정하면 ... 보드폼,보드업데이트 둘다 ... -->
	
	
	
	<script type="text/javascript">
		function mode(num){
			console.log("옴???");
			if(num==1){ //글 수정
				console.log("업데이트폼으로?");
				document.boardViewForm.method = "post";  //seq랑 pg딸려감
				document.boardViewForm.action = "/miniProject/board/boardUpdateForm.do";
				document.boardViewForm.submit();
				
			}else if(num==2){//글삭제
				if(confirm("정말로 삭제할꺼??")){
					document.boardViewForm.method = "post";//seq랑 pg딸려감
					document.boardViewForm.action = "/miniProject/board/boardDelete.do";
					document.boardViewForm.submit();
				}
				
			}else if(num==3){//답글
				document.boardViewForm.method = "post";//seq랑 pg딸려감
				document.boardViewForm.action = "/miniProject/board/boardReplyForm.do";
				document.boardViewForm.submit();
			}
		}
	</script>
	
	
</body>
</html>
<%-- seq가져와야해 이거 어떻게 ? --%>