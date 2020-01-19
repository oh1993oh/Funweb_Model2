package membersvc;

import static db.jdbcUtil.*;
import java.sql.Connection;
import dao.MemberDAO;

public class MemberCheckProService {

	public boolean getCheck(String id, String pass) {
		
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		boolean isCheckSuccess = false;
		int isCheck = memberDAO.getCheck(id,pass);
		
		if(isCheck > 0) {
			commit(con);
			isCheckSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return isCheckSuccess;
	}

}
