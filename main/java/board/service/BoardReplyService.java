package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardReplyService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pseq = Integer.parseInt(request.getParameter("pseq"));  //원글 번호
		int pg = Integer.parseInt(request.getParameter("pg")); //페이지 번호
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");	
		
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		
		//어떤글을 썼는지도 실어가자 
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		map.put("pseq", pseq+""); //원글번호 실어가자~~ 
		
		//db
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.boardReply(map);
		
		//응답
		request.setAttribute("pg", pg);//페이지번호 가지고다녀야함... ㅋ 
		request.setAttribute("display", "/board/boardReply.jsp");
		
		
		return "/index.jsp";
	}

}
