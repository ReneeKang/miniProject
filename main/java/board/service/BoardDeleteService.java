package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardDeleteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		System.out.println("deleteService페이지");
		
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		String subject = request.getParameter("subject");
		
		subject = "[원글이 삭제되었습니다] " + subject;
//		System.out.println("제목??"+subject +"pseq"+pseq);
		
		//db
		Map<String,Object> map = new HashMap<>();
		map.put("seq", seq);
		map.put("pg", pg);
		map.put("reTitle",subject);
		map.put("pseq", pseq);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.boardDelete(map);
		
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardDelete.jsp");
		
		return "/index.jsp";
	}

}
