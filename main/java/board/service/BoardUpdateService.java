package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardUpdateService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		//데이터 4개 다 받자 seq pg sub content
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");	
		
		//db
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("seq", seq+"");
//		map.put("subject", subject);
//		map.put("content", content);
		
		Map<String, Object> map = new HashMap<>();
		map.put("seq", seq);
		map.put("subject", subject);
		map.put("content", content);
		 
		
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.boardUpdate(map); //mybatis엔 3개가 갈수없고 묶어가야해서..
		
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardUpdate.jsp");
		return "/index.jsp";
	}

}
