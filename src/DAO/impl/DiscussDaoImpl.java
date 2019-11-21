package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.DiscussDao;
import Model.Discuss;
import Util.JDBCUtil;

public class DiscussDaoImpl extends JDBCUtil implements DiscussDao {
	public void insert(Discuss discuss) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "";

		stmt.execute(sql);

	}

	public void insertP(Discuss discuss) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = JDBCUtil.getConnection();

		String sql = "INSERT INTO Discuss(topicID,userID,movieID,topic,comment,date,responseCount)"
				+ "VALUES(?,?,?,?,?,?,?)";

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, discuss.getTopicID());
		pstmt.setInt(2, discuss.getUserID());
		pstmt.setInt(3, discuss.getMovieID());
		pstmt.setString(4, discuss.getTopic());
		pstmt.setString(5, discuss.getComment());
		pstmt.setString(6, df.format(discuss.getDate()));
		pstmt.setInt(7, discuss.getResponseCount());

		pstmt.executeUpdate();

		pstmt.close();

	}

	public void delete(Discuss discuss) throws SQLException {
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
