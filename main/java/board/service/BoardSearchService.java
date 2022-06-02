package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardSearchService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		//데이터
		String searchOption = request.getParameter("searchOption");
		String keyword = request.getParameter("keyword");
		int pg = Integer.parseInt(request.getParameter("pg")); //boardList에서 검색하면1페이지가야하니까 hidden해서 1 숨겨옴 ㅋ
		
		int endNum = pg*5;   //뿌려줄때 여기서도 5개씩 뿌려줘야하니까 ㅋ
		int startNum = endNum - 4;
		
		
		//묶어주자~
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		//그리고 중요한거! 지금 
		map.put("startNum", startNum + "");
		map.put("endNum", endNum + "");


		//db - 1페이지당 5개씩
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> list = boardDAO.getBoardSearch(map);
		
		
		
		//페이징처리
		//자~~ 검색잘되니까 이제 페이징처리 가자~~
		//페이징처리    보드리스트서비스랑 비교해서보기~~   
		//총글수가 아니라 내가 검색한 애들 갯수가 필요한거임 ★★★★★★
		int totalA = boardDAO.getTotalSearchA(map); //검색한총글수 그럼 갈때 써치옵션이랑 키워드 필요. 귀찮으니까 map 다보내버리자~
		
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTTML();
		
		
		//응답
		request.setAttribute("pg",pg);
		request.setAttribute("list", list);
		request.setAttribute("searchOption", searchOption);
		request.setAttribute("keyword", keyword);
		request.setAttribute("boardPaging", boardPaging);
		
		request.setAttribute("display", "/board/boardList.jsp");
		
		return "/";
	}

}
