package com.revature.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	@Override
	public void create(User t) {
		// TODO Auto-generated method stub
	}
	@Override
	public User readOne(Integer pk) {
		User u = null;
		String sql = "select * from ers.users where ers_users_id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				
				u.setUsersId(pk);
				u.setUsername(rs.getString("ers_username"));
				u.setPassword(rs.getString("ers_password"));
				u.setFirstName(rs.getString("user_first_name"));
				u.setLastName(rs.getString("user_last_name"));
				u.setEmail(rs.getString("user_email"));
				u.setRoleId(rs.getInt("user_role_id"));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public List<User> readAll() {
		List<User> li = new ArrayList<User>();
		User u;
		String sql = "select * from ers.users";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				
				u.setUsersId(rs.getInt("ers_users_id"));
				u.setUsername(rs.getString("ers_username"));
				u.setPassword(rs.getString("ers_password"));
				u.setFirstName(rs.getString("user_first_name"));
				u.setLastName(rs.getString("user_last_name"));
				u.setEmail(rs.getString("user_email"));
				u.setRoleId(rs.getInt("user_role_id"));
				
				li.add(u);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return li;
	}
	@Override
	public void update(User t) {
		String sql = "update ers.users set ers_username = ?, ers_password = ?, user_first_name = ?, user_last_name = ?, user_email = ?, user_role_id = ? where ers_users_id = ?";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setString(5, t.getEmail());
			ps.setInt(6, t.getRoleId());
			ps.setInt(7, t.getUsersId());
			
			ps.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteByObject(User t) {
		// TODO Auto-generated method stub
	}
	@Override
	public void deleteById(Integer pk) {
		// TODO Auto-generated method stub
	}
	@Override
	public User getByUsername(String username) {
		User u = null;
		String sql = "select * from ers.users where ers_username = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				
				u.setUsersId(rs.getInt("ers_users_id"));
				u.setUsername(rs.getString("ers_username"));
				u.setPassword(rs.getString("ers_password"));
				u.setFirstName(rs.getString("user_first_name"));
				u.setLastName(rs.getString("user_last_name"));
				u.setEmail(rs.getString("user_email"));
				u.setRoleId(rs.getInt("user_role_id"));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public List<User> getUsersByRole(int roleId) {
		List<User> li = new ArrayList<User>();
		User u;
		String sql = "select * from ers.users where user_role_id = ? order by ers_users_id";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, roleId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				
				u.setUsersId(rs.getInt("ers_users_id"));
				u.setUsername(rs.getString("ers_username"));
				u.setPassword(rs.getString("ers_password"));
				u.setFirstName(rs.getString("user_first_name"));
				u.setLastName(rs.getString("user_last_name"));
				u.setEmail(rs.getString("user_email"));
				u.setRoleId(rs.getInt("user_role_id"));
				
				li.add(u);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return li;
	}
}