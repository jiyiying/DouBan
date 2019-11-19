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

		String name = "饺子";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			ResultSet rs = awardsdao.search("SELECT date,organization ,awardType,movieName "
					+ "FROM Person,Awards,Movie " 
					+ "WHERE Person.personID=Awards.personID "
					+ "AND Awards.movieID = Movie.movieID "  
					+ "AND Person.name=" 
					+ "\'" + name + "\'");
			while (rs.next()) {
				
				System.out.println("获奖日期：" + df.format(rs.getDate("date")));
				System.out.println("颁奖组织：" + rs.getString("organization"));
				System.out.println("奖项：" + rs.getString("awardType"));
				System.out.println("电影名：" + rs.getString("movieName"));
				System.out.println();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
