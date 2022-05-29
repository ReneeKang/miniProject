package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardReplyFormService implements CommandProcess { //답글~~얜 원글번호랑 원글 페이지 번호 필요함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int pseq = Integer.parseInt(request.getParameter("seq")); //원글번호
		int pg = Integer.parseInt(request.getParameter("pg")); //원글ㅇ ㅣ있는 페이지 번호 
		System.out.println("답글폼서비스");
		
		
		//갈때 원글번호랑 페이지번호 또 보내야지 ㅋ
		request.setAttribute("pseq", pseq);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReplyForm.jsp");
		
		return "/";
	}

}
