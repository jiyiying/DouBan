package Test.Follow;

import java.sql.SQLException;

import DAO.UserDao;
import DAO.impl.UserDaoImpl;
public class UnfollowTest {
	public static void main(String[] args) {

		UserDao userdao=new UserDaoImpl();
		Integer followerID=12;
		Integer followedID=8;
		
		try {
			userdao.unfollow(followerID,followedID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
