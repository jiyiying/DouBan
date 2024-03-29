package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.SubReviewDao;
import Model.SubReview;
import Util.JDBCUtil;

public class SubReviewDaoImpl extends JDBCUtil implements SubReviewDao {

	public void insert(SubReview subReview) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "";

		stmt.execute(sql);

	}

	public void insertP(SubReview subReview) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = JDBCUtil.getConnection();

		String sql = "INSERT INTO SubReview(commentID,parentType,parentID,userID,movieID,commentDate,comment)"
				+ "VALUES(?,?,?,?,?,?,?)";

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, subReview.getCommentID());
		pstmt.setString(2, subReview.getParentType());
		pstmt.setInt(3, subReview.getParentID());
		pstmt.setInt(4, subReview.getUserID());
		pstmt.setInt(5, subReview.getMovieID());
		pstmt.setString(6, df.format(subReview.getCommentDate()));
		pstmt.setString(7, subReview.getComment());

		pstmt.executeUpdate();

		pstmt.close();

	}

	public void delete(SubReview subReview) throws SQLException {
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
