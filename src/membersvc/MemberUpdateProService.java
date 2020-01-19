package membersvc;

import vo.MemberBean;
import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
public class MemberUpdateProService {

	public boolean MemberUpdate(MemberBean member) {
		
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		boolean isUpdateSuccess = false;
		int updateCount = memberDAO.updateMember(member);
		
		if(updateCount > 0) {
			commit(con);
			isUpdateSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		
		return isUpdateSuccess;
	}

}
