package Test.Admin;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DAO.AwardsDao;
import Factory.DaoFactory;
import Model.Awards;

public class AddAward {
	public static void main(String[] args) throws ParseException, SQLException {
		AwardsDao awardsdao=DaoFactory.getAwardsDaoImpl();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Awards award=new Awards(1,df.parse("2019-10-10"),"最差动漫电影","最差配音奖",14);
		awardsdao.insert(award);
		
	}
}
