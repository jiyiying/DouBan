package Test.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import DAO.PersonDao;
import Factory.DaoFactory;

public class Work {
	public static void main(String[] args) throws ParseException, SQLException {
		PersonDao persondao = DaoFactory.getPersonDaoImpl();

		String name = "����";

		ResultSet rs = persondao.search("select movieName,occupation,character " + "from Movie_Person,movie,person "
				+ "where movie.movieID = Movie_Person.movieID " + "and person.personID = Movie_Person.personID "
				+ "and person.name= \'" + name + "\'");
		
		while (rs.next()) {

			System.out.println("��Ӱ����" + rs.getString("movieName"));
			System.out.println("ְҵ��" + rs.getString("occupation"));
			System.out.println("��ɫ��" + rs.getString("character"));
			System.out.println();
		}
	
	}
}
