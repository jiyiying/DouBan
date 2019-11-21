package Test.Tag;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.UserDao;
import Factory.DaoFactory;

public class HotTagsTest {
	public static void main(String[] args) throws SQLException {
		UserDao userdao=DaoFactory.getUserDaoImpl();
		Integer movieID=12;//哪吒的
		ResultSet rs=userdao.search("select tagTable.tag "
				+"from tagTable,movie "
				+"where tagTable.movieID = movie.movieID "
				+"and movie.movieID = "+movieID
				+" order by count DESC");
		System.out.println("movieID为"+movieID+"的常用标签：");
		while(rs.next()) {
			
			System.out.println(rs.getString("tag"));
		}
		
	}
}
