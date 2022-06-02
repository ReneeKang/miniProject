package board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

//목록(최신순)

public class BoardListService  implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
	
		//목록에1페이지라고 생겨서 그걸 parameter로 담아보냈으니까 그걸 받아야함. 주소타고 넘어온거 받자
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		
		int endNum = pg*5;
		int startNum = endNum - 4;
		
		
		//DB !! 페이지당 5개씩 
		BoardDAO boardDAO = new BoardDAO();
//		List<BoardDTO> list = new ArrayList<BoardDTO>();
//		list = boardDAO.selectArticle(); //다뿌려주는메서드...
//		list = boardDAO.selectBoard(); //켳개칼럼만뿌려줌..
		
		List<BoardDTO> list = boardDAO.selectBoard(startNum, endNum);
		
		
		//페이징 처리
		int totalA = boardDAO.getTotalA(); //총글수 
		int totalP = (totalA-1)/5+1;
		
		
		
		//0530추가... 이전 다음 .. 
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTTML(); //이전 다음 1페 2페 다 만들어줌
		
		
		
		System.out.println("BoardListService.java = " + list);
		System.out.println("totalA =" + totalA);
		System.out.println("totalP =" + totalP);
		
		
		//새로고침 방지
		HttpSession session = request.getSession();
		if(session.getAttribute("memId") != null) { //만약에 세션 memId가 없으면 그때 하나 만들어라   memHit는 반드시 로긴하고나서 만들어짐 ㅋ 
		session.setAttribute("memHit", "0");
		}
		
		//응답
		request.setAttribute("pg", pg); 
		request.setAttribute("list", list);
		request.setAttribute("totalP", totalP);
		
		request.setAttribute("boardPaging", boardPaging); // 0530추가... 보듶이징.java로가자
		
		
		request.setAttribute("display", "/board/boardList.jsp");
		return "/";
	}

}
