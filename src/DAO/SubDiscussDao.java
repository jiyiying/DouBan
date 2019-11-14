package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.SubDiscuss;

public interface SubDiscussDao {
	void insert(SubDiscuss subDiscuss) throws SQLException;
	void insertP(SubDiscuss subDiscuss) throws SQLException;
	void delete(SubDiscuss subDiscuss) throws SQLException;
	void update(String sql) throws SQLException;
	ResultSet search(String sql) throws SQLException;
}
