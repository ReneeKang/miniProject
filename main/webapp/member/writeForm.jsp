<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta charset="UTF-8">
<title>회원가입(Renee)</title>
<style>
#writeForm2 div{
	color:red;
	font-size: 8pt;
	width:80%;
}
.writeForm_title{
	margin-left:20px;
	margin-top:60px;
	margin-bottom:40px;
}
.writeForm2{
	width:80%;
	margin-left:20px;
}

.writeForm2 td{
	height:40px;
}
</style>

<div class="writeForm_title">
<h3>회원가입</h3>

</div>
<form name="writeForm2" id="writeForm2" method="POST" action="/miniProject/member/write.do">
	<table class="writeForm2" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<td align="center" width="100">이름</td>
   			<td>
    			<input type="text" name="name" id="name" placeholder="이름 입력" >
    			<div id="nameDiv"></div>
   			</td>
  		</tr>
  		
  		<tr>
			<td align="center">아이디</td>
			<td>
				<input type="text" name="id" id="userId" placeholder="아이디 입력">
				<%-- <a href="/miniProject/member/checkId.do?id=${requestScope.id}"> --%>
					<input type="button" value="중복체크" id="notCheck" onclick="checkId()">
					<input type="text" name="doCheckId" value="false" hidden>
					<%-- hidden박스의 value에다가  아이디를 여기에 저장해놔도 된다.
					checkOk.jsp에서 사용하기 눌렀을때 그 아이디값을 hidden에 담아주고  나중에 비교하기  --%>
				<div id="idDiv_write"></div>
	   		</td>
		</tr>
		
		<tr>
			<td align="center">비밀번호</td>
			<td>
				<input type="password" name="pwd" id="pwd">
				<div id="pwdDiv_write"></div>
	   		</td>
		</tr>
		
		<tr>
			<td align="center">재확인</td>
			<td>
				<input type="password" name="repwd" id="repwd">
	   		</td>
		</tr>
		
		<tr>
			<td align="center">성별</td>
			<td>
				<input type="radio" name="gender" value="0" checked="checked">남
				<input type="radio" name="gender" value="1">여
			</td>
		</tr>
		
		<tr>
			<td align="center">이메일</td>
			<td>
				<input type="text" name="email1">
				@
				<input type="email" list="email2" name="email2" placeholder="직접입력">
				<datalist id="email2">
					<option value="gmail.com">
					<option value="daum.net">
  	  				<option value="naver.com">
				</datalist>
			</td>
		</tr>
		
		<tr>
			<td align="center">핸드폰</td>
			<td>
				<select name="tel1" style="width: 70px;">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="019">019</option>
				</select>
				-
				<input type="text" name="tel2" size="5">
				-
				<input type="text" name="tel3" size="5">
			</td>
		</tr>
		
		<tr>
			<td align="center">주소</td>
			<td>
				<input type="text" name="zipcode" id="zipcode" readonly>
				<input type="button" value="우편번호검색" onclick="checkPost()"><br>
				<input type="text" name="addr1" id="addr1" placeholder="주소" size="50" readonly><br>
				<input type="text" name="addr2" id="addr2" placeholder="상세주소" size="50">
			</td>
		</tr>
		
		<tr>
			<td colspan ="2" align = "center">
				<input type="button" value="회원가입" onclick="checkWrite()">
				<input type="reset"  value="다시작성">
			</td>
		</tr>
	</table>
</form>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
<%--
function alert(){
	alert("오니?")
	console.log("오니?")
	
	
}--%>
</script>

