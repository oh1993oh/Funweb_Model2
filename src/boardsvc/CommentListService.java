package boardsvc;

import java.sql.Connection;
import static db.jdbcUtil.*;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.CommentBean;

public class CommentListService {

	public ArrayList<CommentBean> getCommantList(int board_num) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		ArrayList<CommentBean> commentList = boardDAO.getCommentList(board_num);
		
		close(con);
		
		return commentList;
	}

}
