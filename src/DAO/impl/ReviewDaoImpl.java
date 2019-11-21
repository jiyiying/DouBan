package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.ReviewDao;
import Model.Review;
import Util.JDBCUtil;

public class ReviewDaoImpl extends JDBCUtil implements ReviewDao {

	public void insert(Review review) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "";

		stmt.execute(sql);

	}

	public void insertP(Review review) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = JDBCUtil.getConnection();

		String sql = "INSERT INTO Review(reviewID,userID,movieID,score,date,title,comment,likeCount,dislikeCount)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, review.getReviewID());
		pstmt.setInt(2, review.getUserID());
		pstmt.setInt(3, review.getMovieID());
		pstmt.setDouble(4, review.getScore());
		pstmt.setString(5, df.format(review.getDate()));
		pstmt.setString(6, review.getTitle());
		pstmt.setString(7, review.getComment());
		pstmt.setInt(8, review.getLikeCount());
		pstmt.setInt(9, review.getDislikeCount());

		pstmt.executeUpdate();

		pstmt.close();

	}

	public void delete(Review review) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "";
		stmt.execute(sql);

	}

	public void update(String sql) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		stmt.execute(sql);

	}

	public ResultSet search(String sql) throws SQLException {
		ResultSet rs = null;
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		rs = stmt.executeQuery(sql);

		return rs;
	}

}
