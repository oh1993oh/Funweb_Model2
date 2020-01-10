package boardaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boardsvc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String nowPage = request.getParameter("page");
		
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num);
		
		request.setAttribute("article", article);
		request.setAttribute("page", nowPage);
		forward = new ActionForward();
		forward.setPath("/board/board_reply.jsp");
		return forward;
	}

}
