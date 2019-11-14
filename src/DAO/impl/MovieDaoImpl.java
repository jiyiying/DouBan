package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import DAO.MovieDao;
import Model.Movie;
import Util.JDBCUtil;

public class MovieDaoImpl extends JDBCUtil implements MovieDao{

	
	public void insert(Movie movie) throws SQLException {
		Connection conn=JDBCUtil.getConnection();
		Statement stmt=conn.createStatement();
		try {
			String sql = "";

			stmt.execute(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	public void insertP(Movie movie) throws SQLException {
		PreparedStatement pstmt=null;
		Connection conn=JDBCUtil.getConnection();
		
		try {
			String sql = "INSERT INTO Movie(movieID,movieName,moviePoster,country,language,releaseDate,length,profile)" + "VALUES(?,?,?,?,?,?,?,?)";
			
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movie.getMovieID());
			pstmt.setString(2, movie.getMovieName());
			pstmt.setString(3, movie.getMoviePoster());
			pstmt.setString(4, movie.getCountry());
			pstmt.setString(5, movie.getLanguage());
			pstmt.setString(6, df.format(movie.getReleaseDate()));
			pstmt.setInt(7, movie.getLength());
			pstmt.setString(8, movie.getProfile());

			pstmt.executeUpdate();
			
			pstmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	
	public void delete(Movie movie) throws SQLException {
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
