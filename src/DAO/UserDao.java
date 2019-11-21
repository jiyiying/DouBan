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
	
	void follow(Integer followerID,Integer followedID) throws SQLException;
	void unfollow(Integer followerID,Integer followedID) throws SQLException;
	ResultSet viewFollowing(Integer userID) throws SQLException;
	ResultSet viewFollower(Integer userID) throws SQLException;
	
	void addNewTag(String tag,Integer movieID) throws SQLException;
	void addTag(String tag,Integer movieID) throws SQLException;
}
