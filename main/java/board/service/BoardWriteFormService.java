package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class BoardWriteFormService  implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		System.out.print("보드폼서비스거쳐감???");
		
		
		
		HttpSession httpsession = request.getSession();
		if(httpsession==null) {
			System.out.println("로긴전임????");
			return "/";
		}
		
		else {
		request.setAttribute("display", "/board/boardWriteForm.jsp");
		return "/";
		}
		
		
	}
	
}
