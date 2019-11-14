package Test.User;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.UserDao;
import Factory.DaoFactory;
import Model.User;

public class UpdateUserInfoTest {
	public static void main(String[] args) {
		/*
		 * 登录之后修改信息，这里默认已经登录aaaa
		 */
		Scanner scan = new Scanner(System.in);
		UserDao userdao = DaoFactory.getUserDaoImpl();

		User user = new User(12,"aaaa","1234","18971504593",null,null,null,null,null);
		String qq="1115677056";
		
		user.setProfilePhoto("aaa");
		user.setQq(qq);
		try {
			String sql="UPDATE [User]"
					+ "SET profilePhoto=\'"+user.getProfilePhoto()
					+"\',email=\'"+user.getEmail()
					+"\',wechat=\'"+user.getWechat()
					+"\',qq=\'"+user.getQq()
					+"\',weibo=\'"+user.getWeibo()+"\'"
					+ "WHERE userName=\'"+user.getUserName()+"\'";
			userdao.update(sql);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
