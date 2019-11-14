package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.PersonDao;
import Model.Person;
import Util.JDBCUtil;

public class PersonDaoImpl extends JDBCUtil implements PersonDao{

	public void insert(Person person) throws SQLException {
		Connection conn=JDBCUtil.getConnection();
		Statement stmt=conn.createStatement();
		try {
			String sql = "";

			stmt.execute(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void insertP(Person person) throws SQLException {
		PreparedStatement pstmt=null;
		Connection conn=JDBCUtil.getConnection();
		
		try {
			String sql = "INSERT INTO Person(personID,name,photo,gender,birthday,birthplace,profile)" + "VALUES(?,?,?,?,?,?,?)";
			
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, person.getPersonID());
			pstmt.setString(2, person.getName());
			pstmt.setString(3, person.getPhoto());
			pstmt.setString(4, person.getGender());
			pstmt.setString(5, df.format(person.getBirthday()));
			pstmt.setString(6, person.getBirthplace());
			pstmt.setString(7, person.getProfile());
	

			pstmt.executeUpdate();
			
			pstmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void delete(Person person) throws SQLException {
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
