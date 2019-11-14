package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ShortReview;

public interface ShortReviewDao {
	void insert(ShortReview shortReview) throws SQLException;
	void insertP(ShortReview shortReview) throws SQLException;
	void delete(ShortReview shortReview) throws SQLException;
	void update(String sql) throws SQLException;
	ResultSet search(String sql) throws SQLException;
}
