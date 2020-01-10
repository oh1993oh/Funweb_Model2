package dao;

import java.sql.Connection;

public class BoardDAO {
	
	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	private Connection con = null;
	
	public static BoardDAO getInstance() {
		
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public boolean isBoardArticleWriter(int board_num, int board_pass) {
		
		return isArticleWriter;
	}
	
	public int deleteArticle(int board_num) {
		
		return deleteArticle;
	}
	
}


