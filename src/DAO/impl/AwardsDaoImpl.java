package DAO.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.AwardsDao;
import Model.Awards;
import Util.JDBCUtil;

public class AwardsDaoImpl extends JDBCUtil implements AwardsDao {

	public void insert(Awards award) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = JDBCUtil.getConnection();

		String sql = "INSERT INTO Awards(personID,date,organization,awardType,movieID)" + "VALUES(?,?,?,?,?)";
		long lg = award.getDate().getTime();

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, award.getPersonID());
		pstmt.setDate(2, new Date(lg));
		pstmt.setString(3, award.getOrganization());
		pstmt.setString(4, award.getAwardType());
		pstmt.setInt(5, award.getMovieID());

		pstmt.executeUpdate();

		pstmt.close();
		System.out.println("添加奖项成功!");

	}

	public void delete(Awards award) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "";
		stmt.execute(sql);

	}

	@Override
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
