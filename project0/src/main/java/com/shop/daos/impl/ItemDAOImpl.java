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
import com.shop.models.User;
import com.shop.util.Menu;

public class ItemDAOImpl implements ItemDAO {
	@Override
	public Integer create(Item newEntry) {
		String sql = "insert into shop.items (item_name, price) values (?, ?) returning id";
		int i = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newEntry.getItemName());
			ps.setBigDecimal(2, newEntry.getPrice());
			
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
	public int delete(Integer primaryKey) {
		int i = 0;
		String sql = "delete from shop.items where id = ?";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, primaryKey);
			i = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return i;
	}
	@Override
	public List<Item> getAvailableItems() {
		List<Item> li = new ArrayList<Item>();
		String sql = "select * from shop.items where status = 0 order by id";
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
	@Override
	public List<Item> getItemsByOwnerId(User user) {
		List<Item> li = new ArrayList<Item>();
		String sql = "select * from shop.items where owner_id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
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
	@Override
	public int updateName(Item item) {
		int a = 0;
		String sql = "update shop.items set item_name = ? where id = ?";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item.getItemName());
			ps.setInt(2, item.getId());
			a = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return a;
	}
	@Override
	public int updatePrice(Item item) {
		int a = 0;
		String sql = "update shop.items set price = ? where id = ?";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBigDecimal(1, item.getPrice());
			ps.setInt(2, item.getId());
			a = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return a;
	}
	@Override
	public int updateStatusAndOwner(Item item) {
		int a = 0;
		String sql = "update shop.items set status = ?, owner_id = ? where id = ?";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item.getStatus());
			ps.setInt(2, item.getOwnerId());
			ps.setInt(3, item.getId());
			a = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return a;
	}
}