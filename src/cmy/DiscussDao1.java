package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Discuss;

public interface DiscussDao {
	void insert(Discuss discuss) throws SQLException;
	void insertP(Discuss discuss) throws SQLException;
	void delete(Discuss discuss) throws SQLException;
	void update(String sql) throws SQLException;
	ResultSet search(String sql) throws SQLException;
}