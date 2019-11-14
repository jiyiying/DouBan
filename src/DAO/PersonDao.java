package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Person;

public interface PersonDao {
	void insert(Person person) throws SQLException;
	void insertP(Person person) throws SQLException;
	void delete(Person person) throws SQLException;
	void update(String sql) throws SQLException;
	ResultSet search(String sql) throws SQLException;
}
