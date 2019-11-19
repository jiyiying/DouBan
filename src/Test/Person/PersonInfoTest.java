package Test.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;

import DAO.PersonDao;
import Factory.DaoFactory;
import Model.Person;

public class PersonInfoTest {
	public static void main(String[] args) throws ParseException, SQLException {
		PersonDao persondao = DaoFactory.getPersonDaoImpl();

		Person person = new Person();
		String name="饺子";
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		ResultSet rs = persondao.search("SELECT * FROM Person WHERE name =\'" + name
				+ "\'");
		while(rs.next()) {
			person.setName(rs.getString("name"));
			person.setGender(rs.getString("gender"));
			person.setBirthday(rs.getDate("birthday"));
			person.setBirthplace(rs.getString("birthplace"));
			person.setProfile(rs.getString("profile"));
			person.setPhoto(rs.getString("photo"));
		}
		
		System.out.println("姓名："+person.getName());
		System.out.println("性别："+person.getGender());
		System.out.println("生日："+df.format(person.getBirthday()));
		System.out.println("出生地："+person.getBirthplace());
		System.out.println("简介："+person.getProfile());
		
		
	}
}
