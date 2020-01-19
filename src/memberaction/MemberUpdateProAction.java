package memberaction;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import membersvc.MemberUpdateProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberUpdateProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		MemberBean member = new MemberBean();
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("pass"));
		member.setName(request.getParameter("name"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setEmail(request.getParameter("email1")+"@"+request.getParameter("email2"));
		
		MemberUpdateProService memberUpdateProService = new MemberUpdateProService();
		boolean ismember_id = memberUpdateProService.MemberUpdate(member);
		
		
		
		if(!ismember_id) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); 
			out.println("<script>");
			out.println("alert('회원님의 비밀번호를 정확히 입력해야 수정이 가능합니다.')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
			forward = new ActionForward();	
			forward.setRedirect(false);
			forward.setPath("/member/memberUpdateForm.jsp");
		}
		
		return forward;
	}

}
