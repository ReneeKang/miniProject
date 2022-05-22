package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

// 맘대로 만들면 안되니까 부모만들고 시작하자~  인터페이스는 어디에 만들까 ? com.control패키지에
public class WriteFormService implements CommandProcess{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		return "/member/writeForm.jsp";
		
		request.setAttribute("display", "/member/writeForm.jsp");
		return "/index.jsp";
		
	}

}
