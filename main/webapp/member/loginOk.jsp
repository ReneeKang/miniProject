<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%
//쿠키
//특정 쿠키를 얻을 수 없으므로 모든 쿠키를 가져온다. 로긴 아이디 머 그렇ㄱ 구해올수없음 

Cookie[] ar = request.getCookies(); 

if(ar != null){
	
	for(int i=0; i<ar.length; i++){
		String cookieName = ar[i].getName();
		String cookieValue = ar[i].getValue();
		System.out.println("쿠키명 = " + cookieName);
		System.out.println("쿠키값 = " + cookieValue);
	}//for
}//if

%>
 --%>
<meta charset="UTF-8">
<title>Insert title here</title>


<%-- <h3>${requestScope.name }님 로그인</h3> --%>
 <h3>${sessionScope.memName }님 로그인</h3> 

<input type="button" value="로그아웃" onclick="location.href='/miniProject/member/logout.do'">
<input type="button" value="회원정보수정" onclick="location.href='/miniProject/member/updateForm.do'">