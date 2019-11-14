package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;

public interface UserDao {
	void insert(User user) throws SQLException;
	void insertP(User user) throws SQLException;
	void delete(User user) throws SQLException;
	void update(String sql) throws SQLException;
	ResultSet search(String sql) throws SQLException;
}
