package Test.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Model.*;
import DAO.*;
import Factory.DaoFactory;

public class RegisterTest {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String userName = scan.next();
		String password = scan.next();
		String phoneNumber = scan.next();
		UserDao userdao = DaoFactory.getUserDaoImpl();

		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);

		ResultSet rs = userdao.search("SELECT *" 
				+ "FROM [user]" 
				+ "WHERE userName = \'" 
				+ user.getUserName() + "\'");

		if (rs.next() && rs.getString("userName").equals(user.getUserName())) {
			System.out.println("用户名已存在");
		}

		rs = userdao.search("SELECT *" + "FROM [user]" + "WHERE phoneNumber = \'" + user.getPhoneNumber() + "\'");

		if (rs.next() && rs.getString("phoneNumber").equals(user.getPhoneNumber())) {
			System.out.println("该手机号已绑定");
		} else {
			userdao.insert(user);
		}

	}

}
