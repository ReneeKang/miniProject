<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! String msg=""; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인(Renee Code)</title>
<style>

body{
	display:flex;
	flex-direction:column;
	align-items:center;
}
#idDiv, #pwdDiv{
	color:red;
	font-size: 8pt;
}

#loginForm{
	
	
}
.login-table{
	
}
.login-item{
	display:block;
	margin-bottom:10px;
}
#logBtn,#newBtn{
	margin:10px;
	
}

.login-msg{
	
}

th{
	width:30%;
}
</style>
</head>

<!-- 내코드 내코드 내코드 내코드  -->
<body>		
	<form name="loginForm" id="loginForm" action="/miniProject/member/login.do" method="post">
	
		<table class="login-table">
			<tr class="login-item">
				<th>아이디</th>
				<td><input type="text" name="id" id="id">
					<div id="idDiv"></div></td>
			</tr>
			
			<tr class="login-item">
				<th>비밀번호</th>
				<td><input type="password" name="pwd" id="pwd">
					<div id="pwdDiv"></div></td>
			</tr>
			<tr class="login-item">
				<td><input type="button" id="logBtn" value="로그인" onclick="loginCheck()" ></td>
				<td><input type="button" id="newBtn"value="회원가입" onclick="location.href='/miniProject/member/writeForm.do'"></td>
			</tr>
			<tr class="login-msg">
				<td colspan="2">
					<%	if(request.getAttribute("msg")!=null){
						//System.out.println(request.getAttribute("msg"));
						msg = (String) request.getAttribute("msg");
						//System.out.println(msg);
						if(msg.equals("1")){
							msg="패스워드가 일치하지 않습니다.";
							System.out.println("pwd-error");
						}
						else if(msg.equals("2"))
							msg="아이디가 존재하지 않습니다. 회원가입 해주세요.";
					}
					%>
					<%=msg %>
				</td>
				
			</tr>
			
			
		</table>
	</form>
	
<script type="text/javascript" src="/miniProject/script/member.js"></script>  
	
</body>
</html>