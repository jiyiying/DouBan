package Test.Discuss;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DiscussDao;
import Factory.DaoFactory;

public class HotDiscussionTest {
	public static void main(String[] args) throws SQLException {
		DiscussDao discussdao=DaoFactory.getDiscussDaoImpl();
		/*
		 * ���ȶ���ʾ��������
		 */
		String sql="select topicID,topic,responseCount "  
				+"from discuss "  
				+"order by responseCount DESC";
		ResultSet rs=discussdao.search(sql);
		while(rs.next()) {
			System.out.print("����ID��"+rs.getString("topicID"));
			System.out.print("  ���⣺"+rs.getString("topic"));
			System.out.print("  ��Ӧ����"+rs.getInt("responseCount"));
			System.out.println();
		}
	}
}
