
package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.SubDiscussDao;
import Model.SubDiscuss;
import Util.JDBCUtil;

public class SubDiscussDaoImpl extends JDBCUtil implements SubDiscussDao{

	
	public void insert(SubDiscuss subDiscuss) throws SQLException {
		Connection conn=JDBCUtil.getConnection();
		Statement stmt=conn.createStatement();
		try {
			String sql = "";

			stmt.execute(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	public void insertP(SubDiscuss subDiscuss) throws SQLException {
		PreparedStatement pstmt=null;
		Connection conn=JDBCUtil.getConnection();
		
		try {
			String sql = "INSERT INTO SubDicuss(dicussID,parentDicussID,discussType,userID,comment,date,likeCount)" + "VALUES(?,?,?,?,?,?,?)";
			
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subDiscuss.getDiscussID());
			pstmt.setInt(2, subDiscuss.getParentDiscussID());
			pstmt.setString(3, subDiscuss.getDiscussType());
			pstmt.setInt(4, subDiscuss.getUserID());
			pstmt.setString(5, subDiscuss.getComment());
			pstmt.setString(6, df.format(subDiscuss.getDate()));
			pstmt.setInt(7, subDiscuss.getLikeCount());
	

			pstmt.executeUpdate();
			
			pstmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	
	public void delete(SubDiscuss subDiscuss) throws SQLException {
		Connection conn=JDBCUtil.getConnection();
		Statement stmt=conn.createStatement();
		try {
			String sql="";
			stmt.execute(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
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
