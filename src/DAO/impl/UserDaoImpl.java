package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.UserDao;
import Model.User;
import Util.JDBCUtil;

public class UserDaoImpl extends JDBCUtil implements UserDao {

	public void insert(User user) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "INSERT INTO [User](userName,password,phoneNumber) " + "VALUES(\'" + user.getUserName() + "\',\'"
				+ user.getPassword() + "\',\'" + user.getPhoneNumber() + "\')";

		stmt.execute(sql);
		System.out.println("注册成功");

	}

	public void insertP(User user) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = JDBCUtil.getConnection();

		String sql = "INSERT INTO User(userID,userName,password,phoneNumber,profilePhoto,email,wechat,qq,weibo)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(2, user.getUserName());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getPhoneNumber());

		pstmt.executeUpdate();

		pstmt.close();

	}

	public void delete(User user) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "";
		stmt.execute(sql);

	}

	public void update(String sql) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		System.out.println("用户信息更新成功！");

	}

	public ResultSet search(String sql) throws SQLException {
		ResultSet rs = null;
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		rs = stmt.executeQuery(sql);

		return rs;
	}

	public void follow(Integer followerID, Integer followedID) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "insert into follow(followerID,followedID) " + "values(+\'" + followerID + "\'" + ",\'"
				+ followedID + "\') ";

		stmt.execute(sql);
		System.out.println("关注成功！");

	}

	public void unfollow(Integer followerID, Integer followedID) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "delete from follow " + "where followerID=\'" + followerID + "\' " + "and followedID=\'"
				+ followedID + "\'";

		stmt.execute(sql);
		System.out.println("取关成功！");

	}

	public ResultSet viewFollowing(Integer userID) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = null;

		String sql = "select userName " + "from [User],follow " + "where followerID = \'" + userID
				+ "\' and followedID=userID";

		rs = stmt.executeQuery(sql);

		return rs;
	}

	public ResultSet viewFollower(Integer userID) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = null;

		String sql = "select userName " + "from [User],follow " + "where followedID = \'" + userID
				+ "\' and followerID=userID";

		rs = stmt.executeQuery(sql);

		return rs;
	}

	public void addNewTag(String tag, Integer movieID) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "insert into " + "tagTable(movieID,tag) " + "values(" + movieID + ",\'" + tag + "\')";

		stmt.execute(sql);
		System.out.println("添加新标签成功");

	}

	public void addTag(String tag, Integer movieID) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = conn.createStatement();

		String sql = "update tagTable " + "set count = count+1 " + "where tag = \'" + tag + "\' and movieID = "
				+ movieID;

		stmt.execute(sql);
		System.out.println("添加标签成功");

	}

}
