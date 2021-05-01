package com.shop.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.daos.EmployeeDAO;
import com.shop.dbutil.ConnectionUtil;
import com.shop.models.Employee;
import com.shop.util.Menu;

public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public Integer create(Employee newEntry) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Employee read(Integer primaryKey) {
		Employee emp = null;
		String sql = "select * from shop.employees where id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, primaryKey);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setId(primaryKey);
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return emp;
	}
	@Override
	public int delete(Integer primaryKey) {
		return primaryKey;
		// TODO Auto-generated method stub
	}
}