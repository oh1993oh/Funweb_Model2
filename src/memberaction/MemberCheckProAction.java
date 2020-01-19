package memberaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membersvc.MemberCheckProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberCheckProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		ActionForward forward = null;
		MemberCheckProService memberCheckProService = new MemberCheckProService();
		boolean isCheck = memberCheckProService.getCheck(id,pass);
		
		if(!isCheck) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); 
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			forward = new ActionForward();	
			forward.setRedirect(false);
			forward.setPath("/member/Check.jsp");
		}
		
		return forward;
	}

}
