package Test.Admin;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DAO.PersonDao;
import Factory.DaoFactory;
import Model.Person;

public class AddPerson {
	public static void main(String[] args) throws ParseException, SQLException {
		PersonDao persondao=DaoFactory.getPersonDaoImpl();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Person person=new Person(null,"Van喻钦",null,"male",df.parse("2019-10-10"),"WuHan","我们一起来Van♂游戏");
		persondao.insert(person);
		
	}
	
}
