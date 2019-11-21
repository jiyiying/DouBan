package Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DAO.MovieDao;
import Factory.DaoFactory;

public class MovieInfo {
	public static void main(String[] args) throws SQLException {
		Integer movieID = 12;
		MovieDao moviedao = DaoFactory.getMovieDaoImpl();
		ResultSet rs = moviedao.search("select *  " + "from movie " + "where movieID=" + movieID);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		while (rs.next()) {
			System.out.println("电影名：" + rs.getString("movieName"));
			System.out.println("国家/地区：" + rs.getString("country"));
			System.out.println("语言：" + rs.getString("language"));
			System.out.println("上映日期：" + sdf.format(rs.getDate("releaseDate")));
			System.out.println("片场：" + rs.getInt("length"));
			System.out.println("电影简介：" + rs.getString("profile"));
		}
		
		rs=moviedao.search("select name " + 
				"from person,Movie_person,movie " + 
				"where person.personID=Movie_Person.personID " + 
				"	and Movie_Person.occupation='导演' " + 
				"	and movie.movieID=Movie_Person.movieID " + 
				"	and movie.movieID ="+movieID);
		
		System.out.print("导演：");
		while(rs.next()) {
			System.out.print(rs.getString("name")+" ");
		}
		System.out.println();
		rs=moviedao.search("select name " + 
				"from person,Movie_person,movie " + 
				"where person.personID=Movie_Person.personID " + 
				"	and Movie_Person.occupation='演员' " + 
				"	and movie.movieID=Movie_Person.movieID " + 
				"	and movie.movieID ="+movieID);
		System.out.print("演员：");
		while(rs.next()) {
			System.out.print(rs.getString("name")+" ");
		}
		System.out.println();
		rs=moviedao.search("select AVERAGE "+
						"FROM (select movieID,CAST(AVG(score) as DECIMAL(13,2)) as AVERAGE " + 
						"from (select movieID,score,[date],userID from shortreview " + 
						"union\r\n" + 
						"select movieID,score,[date],userID from Review) temp  " + 
						"group by movieID) as a " + 
						"join movie " + 
						"on a.movieID = movie.movieID " + 
						"where movie.movieID = "+movieID);
		while(rs.next()) {
			System.out.println("评分："+rs.getString("AVERAGE"));
		}
		
		
	}
}
