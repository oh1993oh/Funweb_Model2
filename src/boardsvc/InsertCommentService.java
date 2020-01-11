package boardsvc;

import java.sql.Connection;

import dao.BoardDAO;

import static db.jdbcUtil.*;
public class InsertCommentService {

	public void insertcomment(int ref_num, String user_id, String comment, int star) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int check = 0;
		check = boardDAO.InsertComment(ref_num,user_id,comment,star);
		
		if(check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
	}

}
