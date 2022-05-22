package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		//데이터
		//id텍스트창에서 입력된 js에 sId로 저장후 새윈도우창에 url태워보낸 id임.
		String userId = request.getParameter("id"); 
		
		//DB
		MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberDAO.isExistId(userId); //사용자가 입력한 id 바로갖다넣음
		
		//응답
		request.setAttribute("exist", exist);
		request.setAttribute("userId",userId);
		
		if(exist) //아이디가 존재하겨있으면
			return "/member/checkFail.jsp"; //id 사용 불가능
	
		else
			return "/member/checkOk.jsp"; // 아이디 사용 가능
		
		
	}

}
