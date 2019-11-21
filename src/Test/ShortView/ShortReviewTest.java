package Test.ShortView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DAO.ReviewDao;
import Factory.DaoFactory;
import Model.ShortReview;

public class ShortReviewTest {
	public static void main(String[] args) throws SQLException {
		ReviewDao shortreviewdao=DaoFactory.getReviewDaoImpl();
	
		String sql="select * " + 
				"from shortreview join movie " + 
				"on shortreview.movieID = movie.movieID " + 
				"where movie.movieID = 8 " ;
		ResultSet rs=shortreviewdao.search(sql);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		
		while(rs.next()) {
			if(!rs.getBoolean("visibility")) {
				continue;
			}
			
			System.out.println("�û�ID��"+rs.getString("userID"));
			if(rs.getBoolean("wantToWatch")) {
				System.out.println("�뿴");
			}else {
				System.out.println("����");
				System.out.println("���֣�"+rs.getDouble("score"));
			}
			System.out.println("�������ݣ�"+rs.getString("comment"));
			System.out.println(sdf.format(rs.getDate("date")));
			System.out.println();
		}
		
	}
}
