package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class UpdateFormService implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		//데이터
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("memId");
		
		System.out.println("updateForm페이지 +id="+userId);
		
		//DB
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.getUserInfo(userId);	
		
		System.out.print(memberDTO.toString());
		//응답
		request.setAttribute("memberDTO", memberDTO);
		request.setAttribute("display", "/member/updateForm.jsp");
		
		return "/";
	}

}
