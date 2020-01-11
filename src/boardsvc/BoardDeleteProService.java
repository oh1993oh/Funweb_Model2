package boardsvc;

import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;

public class BoardDeleteProService {

	public boolean isAriticleWriter(int board_num, String board_pass) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean isArticleWriter = boardDAO.isBoardArticleWriter(board_num, board_pass);
		
		close(con);
		
		return isArticleWriter;
	}

	public boolean removeArticle(int board_num) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean isDeleteSuccess = false;
		int deleteCount = boardDAO.deleteArticle(board_num);
		if(deleteCount > 0) {
			isDeleteSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isDeleteSuccess;
	}
	
	
}
