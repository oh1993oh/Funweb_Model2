package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberBean;

import static db.jdbcUtil.*;

public class MemberDAO {

	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();
	private Connection con = null;

	public static MemberDAO getInstance() {

		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertMember(MemberBean member) {

		int insertCount = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO member VALUES (null,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getGender());
			pstmt.setInt(3, member.getAge());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getId());
			pstmt.setString(6, member.getPasswd());

			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("MemberDAO - insertMember - 오류" + e.getMessage());
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public int selectMemberLogin(String id, String passwd) {

		int loginResult = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT id FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				sql = "SELECT passwd FROM member WHERE id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					if (passwd.equals(rs.getString("passwd"))) {
						loginResult = 1;
					} else {
						loginResult = -1;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO - selectMemberLogin - 오류"+e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return loginResult;
	}

}
