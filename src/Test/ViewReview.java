package Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DAO.UserDao;
import Factory.DaoFactory;

public class ViewReview {
	public static void main(String[] args) throws SQLException {
		UserDao userdao=DaoFactory.getUserDaoImpl();
		Integer movieID=12;//��߸��
		ResultSet rs=userdao.search("select * "
				+"from Review join movie "
				+"on movie.movieID = Review.movieID "
				+"where movie.movieID="+movieID);
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		while(rs.next()) {
			System.out.print("���⣺"+rs.getString("title"));
			System.out.println("���ݣ�"+rs.getString("comment"));
			System.out.println("ʱ�䣺"+df.format(rs.getDate("date")));
			System.out.println();
		}
	}
}
