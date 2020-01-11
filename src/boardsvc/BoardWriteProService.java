package boardsvc;

import vo.BoardBean;
import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean isWriteSuccess = false;
		int insertCount = boardDAO.insertArticle(boardBean);
		
		if(insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isWriteSuccess;
	}

}
