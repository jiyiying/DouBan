package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Review;

public interface ReviewDao {
	void insert(Review review) throws SQLException;
	void insertP(Review review) throws SQLException;
	void delete(Review review) throws SQLException;
	void update(String sql) throws SQLException;
	ResultSet search(String sql) throws SQLException;
}
