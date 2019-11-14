package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.ShortReviewDao;
import Model.ShortReview;
import Util.JDBCUtil;

public class ShortReviewDaoImpl extends JDBCUtil implements ShortReviewDao{

	
	public void insert(ShortReview shortReview) throws SQLException {
		Connection conn=JDBCUtil.getConnection();
		Statement stmt=conn.createStatement();
		try {
			String sql = "";

			stmt.execute(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	
	public void insertP(ShortReview shortReview) throws SQLException {
		PreparedStatement pstmt=null;
		Connection conn=JDBCUtil.getConnection();
		
		try {
			String sql = "INSERT INTO ShortReview(userID,movieID,score,wantToWatch,comment,tag,likeCount,date,visibility)" + "VALUES(?,?,?,?,?,?,?,?,?)";
			
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shortReview.getUserID());
			pstmt.setInt(2, shortReview.getMovieID());
			pstmt.setDouble(3, shortReview.getScore());
			pstmt.setBoolean(4, shortReview.isWantToWatch());
			pstmt.setString(5, shortReview.getComment());
			pstmt.setString(6, shortReview.getTag());
			pstmt.setInt(7, shortReview.getLikeCount());
			pstmt.setString(8,df.format(shortReview.getDate()));
			pstmt.setBoolean(9, shortReview.isVisibility());
	

			pstmt.executeUpdate();
			
			pstmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	
	public void delete(ShortReview shortReview) throws SQLException {
		Connection conn=JDBCUtil.getConnection();
		Statement stmt=conn.createStatement();
		try {
			String sql="";
			stmt.execute(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	public void update(String sql) throws SQLException {
		Connection conn=JDBCUtil.getConnection();
		Statement stmt=conn.createStatement();
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	public ResultSet search(String sql) throws SQLException {
		ResultSet rs = null;
		Connection conn=JDBCUtil.getConnection();
		Statement stmt=conn.createStatement();
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
