package board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터 받자
		int seq = Integer.parseInt(request.getParameter("seq"));
		//
		int pg =  Integer.parseInt(request.getParameter("pg"));
		
		
	
		System.out.println("!ContentService페이지 seq 잘 넘어옵니다.");
		System.out.print(seq);
		
		
		//DB
		BoardDAO boardDAO = new BoardDAO();
//		String content = boardDAO.getContent(seq);
		
		
		//새로고침방지
//				HttpSession session = request.getSession();
//				if(session.getAttribute("memHit")!= null) {
//					//조회수증가
//					boardDAO.setHit(seq);
//					session.removeAttribute("memHit"); //세션 삭제
//				}
//				
				
		//새로고침방지...
		HttpSession session = request.getSession();
			if(session.getAttribute("memHit")!= null) {
				session.removeAttribute("memHit"); //세션삭제....
		}
	
	
		BoardDTO boardDTO = boardDAO.getBoard(seq); //////////////////?????????????????????????????????????????????????
		//응답
//		request.setAttribute("content", content); //내용
		request.setAttribute("pg", pg); //돌아가야하니까 pg도 넘겨주자~~
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("display", "/board/boardView.jsp");
		return "/";
	}

}
