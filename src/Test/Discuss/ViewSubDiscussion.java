package Test.Discuss;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DAO.DiscussDao;
import Factory.DaoFactory;

public class ViewSubDiscussion {
	public static void main(String[] args) throws SQLException {
		DiscussDao discussdao = DaoFactory.getDiscussDaoImpl();

		Integer topicID = 24;
		String sql = "WITH CTE AS (" 
					 +" SELECT  * ,CAST(RIGHT('000' + CAST([discussID] AS VARCHAR), 3) AS VARCHAR(MAX)) AS sort FROM SubDiscuss" 
					 +" WHERE parentDiscussID IS NULL"
					 +" UNION ALL"
					 +" SELECT SubDiscuss.* ,CAST(sort + RIGHT('000' + CAST(SubDiscuss.discussID AS VARCHAR),3) AS VARCHAR(MAX)) AS sort"
					 +" FROM CTE"
					 +" INNER JOIN SubDiscuss ON CTE.discussID = SubDiscuss.parentDiscussID)"
					 +" SELECT distinct * FROM CTE where "
					 + "topicID="+topicID
					 + "ORDER BY sort";
		ResultSet rs = discussdao.search(sql);
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		while(rs.next()) {
			System.out.println("用户ID："+rs.getInt("userID"));
			System.out.println("评论："+rs.getString("comment"));
			System.out.println("上级ID:"+rs.getInt("parentDiscussID"));
			System.out.println("时间："+df.format(rs.getDate("date")));
			System.out.println("赞："+rs.getInt("likeCount"));
			System.out.println();
		}
	}
}
