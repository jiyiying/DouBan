package Test.Admin;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DAO.MovieDao;
import Factory.DaoFactory;
import Model.Movie;

public class AddMovie {
	public static void main(String[] args) throws ParseException, SQLException {
		MovieDao moviedao=DaoFactory.getMovieDaoImpl();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Movie movie=new Movie(null, "����֮��",null,"�ձ�","����",df.parse("2019-10-10"), 119,"��������");
		moviedao.insert(movie);
		
	}
}
