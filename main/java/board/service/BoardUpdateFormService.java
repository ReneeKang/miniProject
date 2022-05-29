package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardUpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		System.out.println("updateForm 보여줘");
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		
		//db
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = boardDAO.getBoard(seq);
		
		//응답
		request.setAttribute("pg", pg);//제자리로오려고
		request.setAttribute("boardDTO", boardDTO);//화면에뿌리려고
		request.setAttribute("display", "/board/boardUpdateForm.jsp");
		
		return "/index.jsp";
	}

}
