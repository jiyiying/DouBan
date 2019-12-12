package Test.Discuss;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DAO.DiscussDao;
import Factory.DaoFactory;

public class ViewDiscussion {
	public static void main(String[] args) throws SQLException {
		DiscussDao discussdao=DaoFactory.getDiscussDaoImpl();
		
		Integer movieID=12;
		String sql="select topic,comment,date,responseCount "
				+"from discuss "
				+"where movieID = "+movieID;
		ResultSet rs=discussdao.search(sql);
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		while(rs.next()) {
			System.out.print("主题："+rs.getString("topic"));
			System.out.println("内容："+rs.getString("comment"));
			System.out.println("时间："+df.format(rs.getDate("date")));
			System.out.println("回应数："+rs.getInt("responseCount"));
			System.out.println();
		}
	}
}