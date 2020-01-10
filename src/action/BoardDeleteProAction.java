package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class BoardDeleteProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String nowPage = request.getParameter("page");
		
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		boolean isRightUser = boardDeleteProService.isAriticleWriter(board_num, request.getParameter("board_pass"));
		
		if(!isRightUser) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			boolean isDeleteSuccess = boardDeleteProService.removeArticle(board_num);
		
		if(!isDeleteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패!')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("BoardList.me?page="+ nowPage);
		}
		
		}
		
		return forward;
	}

}
