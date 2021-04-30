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
		// TODO Auto-generated method stub
		return null;
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
	public void update(Integer primaryKey) {
		// TODO Auto-generated method stub
	}
	@Override
	public void delete(Integer primaryKey) {
		// TODO Auto-generated method stub
	}
}