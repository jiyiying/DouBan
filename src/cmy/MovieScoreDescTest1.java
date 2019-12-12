package Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.MovieDao;
import Factory.DaoFactory;

public class MovieScoreDescTest {
	public static void main(String[] args) throws SQLException {
		MovieDao moviedao = DaoFactory.getMovieDaoImpl();

		ResultSet rs = moviedao.search("select movieName ,AVERAGE " 
						+ "FROM (select movieID,CAST(AVG(score) as DECIMAL(13,2)) as AVERAGE "
						+ "from (select movieID,score,[date],userID from shortreview " + "union "
						+ "select movieID,score,[date],userID from Review) temp " + "group by movieID) as a "
						+ "join movie " + "on a.movieID = movie.movieID");
		while (rs.next()) {
			System.out.println("Ãû³Æ:" + rs.getString("movieName") + "\tÆÀ·Ö" + rs.getDouble("average"));
		}

	}
}