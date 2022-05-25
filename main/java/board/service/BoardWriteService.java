package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteService  implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터    하하하추가
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		
		//넘어오는 데이터 저장
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");	
		
		
		//작성완료페이지 목록버튼???
//		int pg = Integer.parseInt(request.getParameter("pg"));
		
		
		//Map map = new HashMap();
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("id", "ddochi");
//		map.put("name", "또치");
//		map.put("email", "hong@java.com");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		
		
		//데이터를 모델 BoardDTO에 저장
		BoardDTO boardDTO = new BoardDTO("id","또치","메일@gmail.com");
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		System.out.println(boardDTO.toString());
		
		
		//DB
		BoardDAO boardDAO = new BoardDAO();
		//DB 응답
		int su = boardDAO.writeOnBoard(boardDTO);
//		int su2 = boardDAO.writeOnBoard(map);
		
		
		//응답 보내기 - 데이터전송
		request.setAttribute("su", su);
		request.setAttribute("display" ,"/board/boardWrite.jsp");
		return "/";
	}
	
	
}
