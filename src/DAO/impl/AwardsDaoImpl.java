package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.AwardsDao;
import Model.Awards;
import Util.JDBCUtil;

public class AwardsDaoImpl extends JDBCUtil implements AwardsDao{

	
	public void insert(Awards award) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();
		try {
			String sql = "";

			stmt.execute(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	public void insertP(Awards award) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = JDBCUtil.getConnection();

		try {
			String sql = "INSERT INTO Awards(personID,date,organization,awardType,movieID)"
					+ "VALUES(?,?,?,?,?)";

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, award.getPersonID());
			pstmt.setString(2, df.format(award.getDate()));
			pstmt.setString(3, award.getOrganization());
			pstmt.setString(4, award.getAwardType());
			pstmt.setInt(5, award.getMovieID());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	public void delete(Awards award) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();
		try {
			String sql = "";
			stmt.execute(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();
		try {
			stmt.execute(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	public ResultSet search(String sql) throws SQLException {
		ResultSet rs = null;
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
