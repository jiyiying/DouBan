package Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DAO.ReviewDao;
import Factory.DaoFactory;

public class ViewSubReview {
	public static void main(String[] args) throws SQLException {
		ReviewDao reviewdao = DaoFactory.getReviewDaoImpl();

		Integer reviewID = 30;
		String sql = "WITH CTE AS (" 
					 +" SELECT  * ,CAST(RIGHT('000' + CAST([reviewID] AS VARCHAR), 3) AS VARCHAR(MAX)) AS sort FROM SubReview" 
					 +" WHERE parentID IS NULL"
					 +" UNION ALL"
					 +" SELECT SubReview.* ,CAST(sort + RIGHT('000' + CAST(SubReview.reviewID AS VARCHAR),3) AS VARCHAR(MAX)) AS sort"
					 +" FROM CTE"
					 +" INNER JOIN SubReview ON CTE.commentID = SubReview.parentID)"
					 +" SELECT distinct * FROM CTE where "
					 + "reviewID="+reviewID
					 + "ORDER BY sort";
		ResultSet rs = reviewdao.search(sql);
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(rs.next()) {
			System.out.println("�û�ID��"+rs.getInt("userID"));
			System.out.println("���ۣ�"+rs.getString("comment"));
			System.out.println("�ϼ�ID:"+rs.getInt("parentID"));
			System.out.println("ʱ�䣺"+df.format(rs.getDate("commentDate")));
			System.out.println();
		}
	}
}
