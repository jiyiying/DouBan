package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.SubReview;

public interface SubReviewDao {
	void insert(SubReview subReview) throws SQLException;
	void insertP(SubReview subReview) throws SQLException;
	void delete(SubReview subReview) throws SQLException;
	void update(String sql) throws SQLException;
	ResultSet search(String sql) throws SQLException;
}
