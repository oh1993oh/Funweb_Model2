package boardsvc;

import vo.BoardBean;
import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;

public class BoardReplyProService {

	public boolean replyArticle(BoardBean article) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean isReplySuccess = false;
		int insertCount = boardDAO.insertReplyArticle(article);
		
		if(insertCount > 0) {
			commit(con);
			isReplySuccess = true;
		}else {
			rollback(con);
		}
		
		return isReplySuccess;
	}
	
	
	
	
}
