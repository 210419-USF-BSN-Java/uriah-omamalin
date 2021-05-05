package com.shop.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.daos.CustomerDAO;
import com.shop.dbutil.ConnectionUtil;
import com.shop.models.Customer;
import com.shop.util.Menu;

public class CustomerDAOImpl implements CustomerDAO {
	@Override
	public Integer create(Customer newEntry) {
		String sql = "insert into shop.customers (id, first_name, last_name) values (?, ?, ?)";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newEntry.getId());
			ps.setString(2, newEntry.getFirstName());
			ps.setString(3, newEntry.getLastName());
			ps.executeUpdate();
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return newEntry.getId();
	}
	@Override
	public Customer read(Integer primaryKey) {
		Customer c = null;
		String sql = "select * from shop.customers where id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, primaryKey);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c = new Customer();
				c.setId(primaryKey);
				c.setFirstName(rs.getString("first_name"));
				c.setLastName(rs.getString("last_name"));
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return c;
	}
	@Override
	public int delete(Integer primaryKey) {
		return primaryKey;
		// TODO Auto-generated method stub
	}
}