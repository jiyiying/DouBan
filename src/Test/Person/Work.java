package Test.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import DAO.PersonDao;
import Factory.DaoFactory;

public class Work {
	public static void main(String[] args) throws ParseException, SQLException {
		PersonDao persondao = DaoFactory.getPersonDaoImpl();

		String name = "饺子";

		ResultSet rs = persondao.search("select movieName,occupation,character " + "from Movie_Person,movie,person "
				+ "where movie.movieID = Movie_Person.movieID " + "and person.personID = Movie_Person.personID "
				+ "and person.name= \'" + name + "\'");
		
		while (rs.next()) {

			System.out.println("电影名：" + rs.getString("movieName"));
			System.out.println("职业：" + rs.getString("occupation"));
			System.out.println("角色：" + rs.getString("character"));
			System.out.println();
		}
	
	}
}
