package Test.Tag;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.UserDao;
import Factory.DaoFactory;

public class AddTag {

	public static void main(String[] args) throws SQLException {
		UserDao userdao = DaoFactory.getUserDaoImpl();
		String tag = "¶ñÐÄ";
		Integer movieID = 12;

		ResultSet rs = userdao
				.search("select * " + "from tagTable " + "where tag = \'" + tag + "\' and movieID = " + movieID);

		if (!rs.next()) {
			userdao.addNewTag(tag, movieID);
		} else {
			userdao.addTag(tag, movieID);
		}

	}

}
