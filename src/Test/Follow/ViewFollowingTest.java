package Test.Follow;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.UserDao;
import DAO.impl.UserDaoImpl;
import Model.User;

public class ViewFollowingTest {
	public static void main(String[] args) {
		User user = new User(12,"aaaa","1234","18971504593",null,null,null,null,null);
		/*
		 * Ĭ���û���Ϣ��֪����ǰ��¼�û�Ϊaaaa
		 */
		UserDao userdao=new UserDaoImpl();
		ResultSet rs=null;
		try {
			rs=userdao.viewFollowing(user.getUserID());
			System.out.println("���ڹ�ע:");
			while(rs.next()) {
				System.out.println(rs.getString("userName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
