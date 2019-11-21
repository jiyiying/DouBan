package DAO.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.PersonDao;
import Model.Person;
import Util.JDBCUtil;

public class PersonDaoImpl extends JDBCUtil implements PersonDao {

	public void insert(Person person) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = JDBCUtil.getConnection();

		String sql = "INSERT INTO Person(name,photo,gender,birthday,birthplace,profile)" + "VALUES(?,?,?,?,?,?)";
		long lg = person.getBirthday().getTime();

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, person.getName());
		pstmt.setString(2, person.getPhoto());
		pstmt.setString(3, person.getGender());
		pstmt.setDate(4, new Date(lg));
		pstmt.setString(5, person.getBirthplace());
		pstmt.setString(6, person.getProfile());

		pstmt.executeUpdate();

		pstmt.close();
		System.out.println("添加人物信息成功！");

	}

	public void delete(Person person) throws SQLException {
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
