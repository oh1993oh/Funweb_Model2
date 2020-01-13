package boardaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardsvc.BoardReplyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		String nowPage = request.getParameter("page");
		
		BoardBean article = new BoardBean();
		article.setboard_num(Integer.parseInt(request.getParameter("board_num")));
		article.setboard_name(request.getParameter("board_name"));
		article.setboard_pass(request.getParameter("board_pass"));
		article.setboard_subject(request.getParameter("board_subject"));
		article.setboard_content(request.getParameter("board_content"));
		article.setboard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
		article.setboard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
		article.setboard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		
		BoardReplyProService boardReplyProService = new BoardReplyProService();
		boolean isReplySuccess = boardReplyProService.replyArticle(article);
		
		if(!isReplySuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // response 객체로부터 PrintWriter 객체 얻어오기
			out.println("<script>");
			out.println("alert('답글 등록 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("BoardList.bo?page=" + nowPage);
		}
		
		
		return forward;
	}

}
