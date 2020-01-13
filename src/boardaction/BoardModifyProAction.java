package boardaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardsvc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		boolean isRightUser = boardModifyProService.isArticleWriter(board_num, request.getParameter("board_num"));
		
		if(!isRightUser) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			BoardBean article = new BoardBean();
			article.setboard_num(board_num);
			article.setboard_name(request.getParameter("board_name"));
			article.setboard_subject(request.getParameter("board_subject"));
			article.setboard_content(request.getParameter("board_content"));
		
			boolean isModifySuccess = boardModifyProService.modifyArticle(article);
			
			if(!isModifySuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('글 수정 실패!')");
				out.println("history.back()");
				out.println("</script>");
			}else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("BoardDetail.bo?board_num=" + board_num + "&page=" + page);
			}
		}
		
		return forward;
	}

}
