package com.shop.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.daos.ItemDAO;
import com.shop.dbutil.ConnectionUtil;
import com.shop.models.Item;
import com.shop.util.Menu;

public class ItemDAOImpl implements ItemDAO {
	@Override
	public Integer create(Item newEntry) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Item read(Integer primaryKey) {
		Item i = null;
		String sql = "select * from shop.items where id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, primaryKey);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = new Item();
				i.setId(primaryKey);
				i.setItemName(rs.getString("item_name"));
				i.setOwnerId(rs.getInt("owner_id"));
				i.setPrice(rs.getBigDecimal("price"));
				i.setStatus(rs.getInt("status"));
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return i;
	}
	@Override
	public void update(Integer primaryKey) {
		// TODO Auto-generated method stub
	}
	@Override
	public void delete(Integer primaryKey) {
		// TODO Auto-generated method stub
	}
	@Override
	public List<Item> getAvailableItems() {
		List<Item> li = new ArrayList<Item>();
		String sql = "select * from shop.items where status = 0";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Item i = new Item();
				i.setId(rs.getInt("id"));
				i.setItemName(rs.getString("item_name"));
				i.setPrice(rs.getBigDecimal("price"));
				i.setStatus(rs.getInt("status"));
				i.setOwnerId(rs.getInt("owner_id"));
				li.add(i);
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return li;
	}
}