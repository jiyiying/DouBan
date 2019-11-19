package Test.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DAO.AwardsDao;
import Factory.DaoFactory;
import Model.Awards;
import Model.Movie;

public class AwardsInfo {

	public static void main(String[] args) throws ParseException {
		AwardsDao awardsdao = DaoFactory.getAwardsDaoImpl();

		String name = "����";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			ResultSet rs = awardsdao.search("SELECT date,organization ,awardType,movieName "
					+ "FROM Person,Awards,Movie " 
					+ "WHERE Person.personID=Awards.personID "
					+ "AND Awards.movieID = Movie.movieID "  
					+ "AND Person.name=" 
					+ "\'" + name + "\'");
			while (rs.next()) {
				
				System.out.println("�����ڣ�" + df.format(rs.getDate("date")));
				System.out.println("�佱��֯��" + rs.getString("organization"));
				System.out.println("���" + rs.getString("awardType"));
				System.out.println("��Ӱ����" + rs.getString("movieName"));
				System.out.println();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
