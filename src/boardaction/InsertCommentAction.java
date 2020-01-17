package boardaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boardsvc.InsertCommentService;
import vo.ActionForward;

public class InsertCommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String comment = request.getParameter("comment");
		String member_id = request.getParameter("member_id");
		int star = Integer.parseInt(request.getParameter("star"));
		String page = request.getParameter("page");
		
		InsertCommentService insertCommentService = new InsertCommentService();
		insertCommentService.insertcomment(board_num, member_id, comment, star);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("BoardDetail.bo?board_num="+board_num+"&page="+page);
		
		
		return forward;
	}

}
