package Test.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import DAO.UserDao;
import Factory.DaoFactory;
import Model.User;

public class LoginTest {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		String userName = scan.next();
		String password = scan.next();
		UserDao userdao = DaoFactory.getUserDaoImpl();

		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);

		ResultSet rs = userdao.search("SELECT * FROM [user] WHERE userName =\'" 
				+ user.getUserName()		
				+ "\' AND password = \'" 
				+ user.getPassword() + "\'");

		if (!rs.next()) {
			System.out.println("�û������������!");
		} else {
			System.out.println("��¼�ɹ���" + "��¼�û���" + rs.getString("userName"));
		}

	}
}
