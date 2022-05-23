package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//로긴 id.pwd
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		//db
		MemberDAO memberDAO = new MemberDAO();
//		String name = memberDAO.loginCheck(id,pwd);
		
		MemberDTO dtoNameEmail = memberDAO.loginCheckPlusEmail(id, pwd);
		System.out.println("dtoNameEmail="+dtoNameEmail);
		String name=dtoNameEmail.getName();
		String userEmail = dtoNameEmail.getEmail1()+"@"+dtoNameEmail.getEmail2();
		System.out.println("userEmail="+userEmail);
		
		
		
		String loginResult = null;
		String failNum=null;
		//응답
		if(name.equals("1")) {
//			request.setAttribute("msg", "패스워드가 일치하지 않습니다.");
//			return "/index.jsp";
			
			loginResult = "fail";
			failNum = "1";
			request.setAttribute("loginResult", loginResult);
			request.setAttribute("failNum", failNum);
			
		}
		else if(name.equals("2")){ //if(name==null)
//			request.setAttribute("msg", "아이디가 존재하지 않습니다. 회원가입 해주세요.");
//			return "/index.jsp";
			loginResult = "fail";
			failNum="2";
			request.setAttribute("loginResult", loginResult);
			request.setAttribute("failNum", failNum);
		}
		else {
			System.out.println("name = " + name);
//			return "/index.jsp";
			
//			//쿠키생성해보자~~!!
////			Cookie cookie = new Cookie("쿠키명",값);
//			Cookie cookie = new Cookie("memName",name);
//			cookie.setPath("/");  //쿠키생존범위지정 ㅋ 루트하위에서 다 알고있어라.
////			cookie.setMaxAge(3); // 3초 동안 살아있어라. 초 단위
//			cookie.setMaxAge(30*60); // 30분
//			response.addCookie(cookie);// 쿠키를 클라이언트로 보내기
//			
//			
//			Cookie cookie2 = new Cookie("memId",id);
//			cookie.setPath("/");
//			cookie2.setMaxAge(30*60); //초 - 30분
//			response.addCookie(cookie2);
			
			
			
			//세션
			HttpSession session = request.getSession();//세션 생성
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", userEmail);
			
//			request.setAttribute("name", name);
//			request.setAttribute("id", id);
//				
		}
		
//		request.setAttribute("id", id); 절대안됨 이렇게 하면 안됨 ㅋ ㅋㅋ
//		return "/index.jsp";   
		return "/index.jsp";   
		
		
	}

}
