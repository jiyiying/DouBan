package Test.Discuss;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DiscussDao;
import Factory.DaoFactory;

public class HotDiscussionTest {
	public static void main(String[] args) throws SQLException {
		DiscussDao discussdao=DaoFactory.getDiscussDaoImpl();
		/*
		 * 按热度显示讨论主题
		 */
		String sql="select topicID,topic,responseCount "  
				+"from discuss "  
				+"order by responseCount DESC";
		ResultSet rs=discussdao.search(sql);
		while(rs.next()) {
			System.out.print("讨论ID："+rs.getString("topicID"));
			System.out.print("  主题："+rs.getString("topic"));
			System.out.print("  回应数："+rs.getInt("responseCount"));
			System.out.println();
		}
	}
}
