package boardaction;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import boardsvc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		BoardBean boardBean = null;
		
		String realFolder = ""; 
		String saveFolder = "/boardUpload";
		int fileSize = 10 * 1024 * 1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(
				request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		
		boardBean = new BoardBean();
		boardBean.setboard_name(multi.getParameter("board_name"));
		boardBean.setboard_pass(multi.getParameter("board_pass"));
		boardBean.setboard_subject(multi.getParameter("board_subject"));
		boardBean.setboard_content(multi.getParameter("board_content"));
		boardBean.setboard_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		BoardWriteProService boardWriteProService = new BoardWriteProService();
		boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);
		
		if(!isWriteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('게시물 등록 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("BoardList.bo");
			forward.setRedirect(true);
		}
		return forward;
	}

	
}
