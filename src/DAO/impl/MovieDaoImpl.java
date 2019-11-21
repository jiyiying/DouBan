package DAO.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.MovieDao;
import Model.Movie;
import Util.JDBCUtil;

public class MovieDaoImpl extends JDBCUtil implements MovieDao {

	public void insert(Movie movie) throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = JDBCUtil.getConnection();

		String sql = "INSERT INTO Movie(movieName,moviePoster,country,language,releaseDate,length,profile)"
				+ "VALUES(?,?,?,?,?,?,?)";
		long lg = movie.getReleaseDate().getTime();

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, movie.getMovieName());
		pstmt.setString(2, movie.getMoviePoster());
		pstmt.setString(3, movie.getCountry());
		pstmt.setString(4, movie.getLanguage());
		pstmt.setDate(5, new Date(lg));
		pstmt.setInt(6, movie.getLength());
		pstmt.setString(7, movie.getProfile());

		pstmt.executeUpdate();

		pstmt.close();
		System.out.println("添加电影成功！");

	}

	public void delete(Movie movie) throws SQLException {
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
