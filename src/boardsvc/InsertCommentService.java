package boardsvc;

import java.sql.Connection;

import dao.BoardDAO;

import static db.jdbcUtil.*;
public class InsertCommentService {

	public void insertcomment(int board_num, String member_id, String comment, int star) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int check = 0;
		check = boardDAO.InsertComment(board_num,member_id,comment,star);
		
		if(check > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
	}

}
