package boardsvc;

import java.sql.Connection;

import dao.BoardDAO;

import static db.jdbcUtil.*;

import vo.BoardBean;

public class BoardModifyProService {

	public boolean isArticleWriter(int board_num, String board_pass) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean isArticleWriter = boardDAO.isBoardArticleWriter(board_num, board_pass);
		
		
		return isArticleWriter;
	}

	public boolean modifyArticle(BoardBean article) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		
		boolean isModifySuccess = false;
		int updateCount = boardDAO.updateArticle(article);
		if(updateCount > 0) {
			isModifySuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isModifySuccess;
	}

}
