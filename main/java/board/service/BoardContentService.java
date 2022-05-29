package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardContentService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터 받자  
		
		// boardContent에서 돌아가기 눌렀을때 
		// 넘어온 url에 값이 없는데 여기서 getParameter하기 때문에
		// 여기서 에러가 나는것임 ㅋ
		// 콘솔창 보면 
		//java.lang.NumberFormatException: null
//		at java.base/java.lang.Integer.parseInt(Integer.java:622)
		//에러 나는것 확인 가능 ㅋ  없는데 요청해서 변환요청함 ㅋ
 		int seq = Integer.parseInt(request.getParameter("seq"));
 				//
 		//int pg = Integer.parseInt(request.getParameter("pg"));
 		//urlp에 딸려오기때문에 굳이 이렇게 저장해서 set할필요 없이 jsp페이지에서 param.pg로 정보 얻어올 수 있다 .ㅎㅎㅎ
		
		
	
		System.out.println("!ContentService페이지 seq 잘 넘어옵니다.");
		System.out.print(seq);
		
		//DB
		BoardDAO boardDAO = new BoardDAO();
		//처음에 내용만 보여주게 만들었는데, 돌아가기 가능하게 만들거라 pg도 필요하고~~ //그냥통으로받음
		//select해서 내용이랑 음????/
//		String content = boardDAO.getContent(seq);
//		BoardDTO boardDTO = boardDAO.getBoard(seq);
		
		//응답
//		request.setAttribute("content", content); //내용
//		request.setAttribute("boardDTO", boardDTO);
	//	request.setAttribute("pg", pg);
		
		request.setAttribute("display", "/board/boardContent.jsp");
		
		return "/";
	}

}
