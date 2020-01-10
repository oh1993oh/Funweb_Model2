package boardaction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardsvc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService boardListService = new BoardListService();
		int listCount = boardListService.getListCount();

		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		articleList = boardListService.getArticleList(page,limit);
		
		int maxPage = (int)((double)listCount / limit + 0.95);
		int startPage = ((int)((double)page / 10 + 0.9) - 1) * 10 + 1;
		int endPage = startPage + 10 - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(page,maxPage,startPage, endPage, listCount);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("artilceList", articleList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/board/board_list.jsp");
		
		return forward;
	}

}
