package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Awards;

public interface AwardsDao {
	void insert(Awards award) throws SQLException;
	void insertP(Awards award) throws SQLException;
	void delete(Awards award) throws SQLException;
	void update(String sql) throws SQLException;
	ResultSet search(String sql) throws SQLException;
}
