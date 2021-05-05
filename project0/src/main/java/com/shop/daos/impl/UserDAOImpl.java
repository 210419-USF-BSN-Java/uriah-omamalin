package com.shop.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.daos.UserDAO;
import com.shop.dbutil.ConnectionUtil;
import com.shop.models.User;
import com.shop.util.Menu;

public class UserDAOImpl implements UserDAO {
	@Override
	public Integer create(User newEntry) {
		String sql = "insert into shop.users (user_type) values (?) returning id";
		int i = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newEntry.getUserType());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				i = rs.getInt("id");
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return i;
	}
	@Override
	public User read(Integer primaryKey) {
		User user = null;
		String sql = "select * from shop.users where id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, primaryKey);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(primaryKey);
				user.setUserType(rs.getInt("user_type"));
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return user;
	}
	@Override
	public int delete(Integer primaryKey) {
		return primaryKey;
		// TODO Auto-generated method stub
	}
}