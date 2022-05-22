package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardWriteFormService  implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		System.out.print("보드폼서비스거쳐감???");
		
		request.setAttribute("display", "/board/boardWriteForm.jsp");
		return "/";
	}
	
}
