package Test.Follow;

import java.sql.SQLException;

import DAO.UserDao;
import DAO.impl.UserDaoImpl;

public class FollowTest {

	public static void main(String[] args) {
	
		/*
		 * Ĭ���û���Ϣ��֪����ǰ��¼�û�Ϊaaaa
		 */
		UserDao userdao=new UserDaoImpl();
		Integer followerID=8;
		Integer followedID=12;
		try {
			userdao.follow(followerID,followedID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
