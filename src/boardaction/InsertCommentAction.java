package boardaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boardsvc.InsertCommentService;
import vo.ActionForward;

public class InsertCommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int ref_num = Integer.parseInt(request.getParameter("board_num"));
		String comment = request.getParameter("comment");
		String user_id = request.getParameter("user_id");
		int star = Integer.parseInt(request.getParameter("star"));
		String page = request.getParameter("page");
		
		InsertCommentService insertCommentService = new InsertCommentService();
		insertCommentService.insertcomment(ref_num, user_id, comment, star);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("BoardDetail.bo?board_num="+ref_num+"&page="+page);
		
		
		return null;
	}

}
