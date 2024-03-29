package Test.Follow;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.UserDao;
import DAO.impl.UserDaoImpl;
import Model.User;

public class ViewFollowerTest {
	public static void main(String[] args) {
		User user = new User(12, "aaaa", "1234", "18971504593", null, null, null, null, null);
		/*
		 * 默认用户信息已知，当前登录用户为aaaa
		 */
		UserDao userdao = new UserDaoImpl();
		ResultSet rs=null;
		
		try{
			rs = userdao.viewFollower(user.getUserID());
			System.out.println("我的粉丝:");
			while (rs.next()) {
				System.out.println(rs.getString("userName"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
