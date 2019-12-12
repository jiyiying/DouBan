package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Movie;

public interface MovieDao {
	void insert(Movie movie) throws SQLException;
	void delete(Movie movie) throws SQLException;
	void update(String sql) throws SQLException;
	ResultSet search(String sql) throws SQLException;
}
