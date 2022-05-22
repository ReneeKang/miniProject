package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		/*
		 * //쿠키
		 * 
		 * Cookie[] ar = request.getCookies(); // 특정 쿠키 얻을수없으므로 모든 쿠키를 가져온다.
		 * 
		 * if(ar != null) { for(int i=0; i<ar.length; i++) { // 쿠키를 찾아라 ~~~~
		 * if(ar[i].getName().equals("memName")) { ar[i].setPath("/");// / 로잡혀있는걸 root로
		 * 해서 그 아래 쿠키 다 죽임 ar[i].setMaxAge(0); //쿠키 삭제 //삭제 후 클라이언트한테 알려좀 보내기
		 * response.addCookie(ar[i]); //클라이언트로 보내기 애드 시켜주기 ㅋ
		 * 
		 * } if(ar[i].getName().equals("memId")) { ar[i].setPath("/");// / 로잡혀있는걸 root로
		 * 해서 그 아래 쿠키 다 죽임 ar[i].setMaxAge(0); //쿠키 삭제 response.addCookie(ar[i]);
		 * //클라이언트로 보내기
		 * 
		 * }
		 * 
		 * 
		 * } }
		 */
		
		
		
		//세션
		
		HttpSession session = request.getSession();
		
		//각각의 세션 삭제
//		session.removeAttribute("memName");
//		session.removeAttribute("memId");
		
		
		//모든 세션 삭제
		session.invalidate(); //무효화
		
		
		
		return "/index.jsp";
	}

}
