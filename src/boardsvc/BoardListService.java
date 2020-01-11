package boardsvc;

import static db.jdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;

public class BoardListService {

	public int getListCount() {

		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);

		int listCount = boardDAO.selectListCount();
		close(con);

		return listCount;
	}

	public ArrayList<BoardBean> getArticleList(int page, int limit) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		ArrayList<BoardBean> articleList = null;
		articleList = boardDAO.selectArticleList(page,limit);
		
		close(con);
		
		return articleList;
	}

}
