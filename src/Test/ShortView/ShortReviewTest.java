package Test.ShortView;

import DAO.ReviewDao;
import Factory.DaoFactory;
import Model.ShortReview;

public class ShortReviewTest {
	public static void main(String[] args) {
		ReviewDao reviewdao=DaoFactory.getReviewDaoImpl();
		String tag="���";
		String comment="̫����";
		ShortReview shortreview=new ShortReview();
		
	}
}
