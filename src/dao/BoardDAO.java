package dao;

import static db.jdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.BoardBean;
import vo.CommentBean;

public class BoardDAO {

	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();
	private Connection con = null;

	public static BoardDAO getInstance() {

		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public boolean isBoardArticleWriter(int board_num, String board_pass) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isArticleWriter = false;

		try {
			String sql = "SELECT board_pass FROM board WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (board_pass.equals(rs.getString("board_pass"))) {
					isArticleWriter = true;
				}
			}

		} catch (SQLException e) {
			System.out.println("BoardDAO - isBoardArticleWriter() 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return isArticleWriter;
	}

	public int deleteArticle(int board_num) {

		PreparedStatement pstmt = null;
		int deleteCount = 0;

		try {
			String sql = "DELETE FROM board WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			deleteCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("BoardDAO - deleteArticle() 오류 - " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}

	public BoardBean selectArticle(int board_num) {
		System.out.println("boardDAO - selectArticle");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;

		try {
			String sql = "SELECT * FROM board WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardBean = new BoardBean();
				boardBean.setboard_num(rs.getInt("board_num"));
				boardBean.setboard_name(rs.getString("board_name"));
				boardBean.setboard_subject(rs.getString("board_subject"));
				boardBean.setboard_content(rs.getString("board_content"));
				boardBean.setboard_file(rs.getString("board_file"));
				boardBean.setboard_re_ref(rs.getInt("board_re_ref"));
				boardBean.setboard_re_lev(rs.getInt("board_re_lev"));
				boardBean.setboard_re_seq(rs.getInt("board_re_seq"));
				boardBean.setboard_readcount(rs.getInt("board_readcount"));
				boardBean.setboard_date(rs.getDate("board_date"));
				System.out.println(rs.getString("board_content"));
			}

		} catch (SQLException e) {
			System.out.println("BoardDAO - selectArticle() 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return boardBean;
	}

	public int updateReadcount(int board_num) {
		
		System.out.println("boardDAO - updateReadcount");
		
		PreparedStatement pstmt = null;
		int updateCount = 0;

		try {
			String sql = "UPDATE board SET board_readcount=board_readcount+1 WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			updateCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("BoardDAO - updateReadcount() 오류 - " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return updateCount;
	}

	public int selectListCount() {
		
		System.out.println("BoardDAO - selectListCount");
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT count(*) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("BoardDAO - selectListCount() 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<BoardBean> selectArticleList(int page, int limit) {
		
		System.out.println("BoardDAO - selectArticleList");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		int startRow = (page - 1) * 10;

		try {
			String sql = "SELECT * FROM board ORDER BY board_re_ref desc,board_re_seq asc LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardBean boardBean = new BoardBean();
				boardBean.setboard_num(rs.getInt("board_num"));
				boardBean.setboard_name(rs.getString("board_name"));
				boardBean.setboard_subject(rs.getString("board_subject"));
				boardBean.setboard_content(rs.getString("board_content"));
				boardBean.setboard_file(rs.getString("board_file"));
				boardBean.setboard_re_ref(rs.getInt("board_re_ref"));
				boardBean.setboard_re_lev(rs.getInt("board_re_lev"));
				boardBean.setboard_re_seq(rs.getInt("board_re_seq"));
				boardBean.setboard_readcount(rs.getInt("board_readcount"));
				boardBean.setboard_date(rs.getDate("board_date"));
				articleList.add(boardBean);
			}

		} catch (SQLException e) {
			System.out.println("BoardDAO - selectArticleList() 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;
	}

	public int updateArticle(BoardBean article) {
		
		System.out.println("BoardDAO - updateArticle");
		
		PreparedStatement pstmt = null;
		int updateCount = 0;

		try {
			String sql = "UPDATE board SET board_name=?,board_subject=?,board_content=? WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getboard_name());
			pstmt.setString(2, article.getboard_subject());
			pstmt.setString(3, article.getboard_content());
			pstmt.setInt(4, article.getboard_num());
			updateCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("BoardDAO - updateArticle() 오류 - " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return updateCount;
	}

	public int insertReplyArticle(BoardBean article) {
		
		System.out.println("BoardDAO - insertReplyArticle");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int num = 1;
		int insertCount = 0;
		int re_ref = article.getboard_re_ref();
		int re_lev = article.getboard_re_lev();
		int re_seq = article.getboard_re_seq();

		try {
			String sql = "SELECT MAX(board_num) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1) + 1;
			}

			sql = "UPDATE board SET board_re_seq=board_re_seq+1 WHERE board_re_ref=? AND board_re_seq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();

			if (updateCount > 0) {
				commit(con);
			} else {
				rollback(con);
			}

			re_seq = re_seq + 1;
			re_lev = re_lev + 1;

			sql = "INSERT INTO board VALUES(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getboard_name());
			pstmt.setString(3, article.getboard_pass());
			pstmt.setString(4, article.getboard_subject());
			pstmt.setString(5, article.getboard_content());
			pstmt.setString(6, "");
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("BoardDAO - insertReplyArticle() 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}

	public int insertArticle(BoardBean boardBean) {
		
		System.out.println("BoardDAO - insertArticle");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int num = 0;
		int insertCount = 0;

		try {
			String sql = "SELECT MAX(board_num) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}

			sql = "INSERT INTO board VALUES(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, boardBean.getboard_name());
			pstmt.setString(3, boardBean.getboard_pass());
			pstmt.setString(4, boardBean.getboard_subject());
			pstmt.setString(5, boardBean.getboard_content());
			pstmt.setString(6, boardBean.getboard_file());
			pstmt.setInt(7, num);
			pstmt.setInt(8, boardBean.getboard_re_lev());
			pstmt.setInt(9, boardBean.getboard_re_seq());
			pstmt.setInt(10, boardBean.getboard_readcount());

			insertCount = pstmt.executeUpdate(); // INSERT 실행 결과 값을 int형 변수로 저장

		} catch (SQLException e) {
			System.out.println("insertArticle() 오류 - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}

	public ArrayList<CommentBean> getCommentList(int board_num) {
		
		System.out.println("BoardDAO - getCommentList");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommentBean> commentList = new ArrayList<CommentBean>();

		try {
			String sql = "select Member_id,comment,star,date from comment where board_num=? order by com_num";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				CommentBean commentBean = new CommentBean(); // 중복을 제거하기 위해 여기 선언 
				commentBean.setMember_id(rs.getString("Member_id"));
				commentBean.setComment(rs.getString("comment"));
				commentBean.setStar(rs.getInt("star"));
				commentBean.setDate(rs.getDate("date"));
				commentList.add(commentBean);
			}
		} catch (SQLException e) {
			System.out.println("BoardDAO -getCommentList - 오류" + e.getMessage());
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return commentList;
	}

	public int InsertComment(int board_num, String member_id, String comment, int star) {
		
		System.out.println("BoardDAO - InsertComment");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int com_num = 0; 
		int insertcount = 0;
		
		
		try {
			String sql = "Select max(com_num) from comment"; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				com_num = rs.getInt("max(com_num)")+1;
			}else {
				com_num = 1;
			}
			sql = "insert into comment values(?,?,?,now(),?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.setString(2, member_id);
			pstmt.setString(3, comment);
			pstmt.setInt(4, star);
			pstmt.setInt(5, com_num);
			insertcount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("boardDAO - InsertComment - 오류"+e.getMessage());
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return insertcount;
	}

}
