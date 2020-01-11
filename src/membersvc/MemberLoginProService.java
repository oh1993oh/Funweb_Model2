package membersvc;

import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberLoginProService {

	public int memberLogin(String id, String passwd) {

		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);

		int loginResult = memberDAO.selectMemberLogin(id, passwd);

		close(con);

		return loginResult;
	}
}
