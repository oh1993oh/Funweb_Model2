package memberaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import membersvc.MemberLoginProService;
import vo.ActionForward;

public class MemberLoginProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		ActionForward forward = null;
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("pass");
		System.out.println(id + ", " + passwd);
		
		MemberLoginProService memberLoginProService = new MemberLoginProService();
		int loginResult = memberLoginProService.memberLogin(id, passwd);


		if(loginResult == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); 
			out.println("<script>");
			out.println("alert('ID 가 존재하지 않습니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else if(loginResult == -1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); 
			out.println("<script>");
			out.println("alert('패스워드가 틀렸습니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			HttpSession session = request.getSession();
			System.out.println("로그인 완료!");
			session.setAttribute("id", id);
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("main.me");
		}
		
		return forward;
		
	}

}
