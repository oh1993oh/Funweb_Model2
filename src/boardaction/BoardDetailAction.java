package boardaction;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boardsvc.CommentListService;
import boardsvc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;
import vo.CommentBean;

public class BoardDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num);
		CommentListService comment = new CommentListService();
		ArrayList<CommentBean> commentList = comment.getCommantList(board_num);
		request.setAttribute("comment", commentList);
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/board/board_view.jsp");
		return forward;
	}

}
