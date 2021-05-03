package com.shop.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.shop.daos.OfferDAO;
import com.shop.dbutil.ConnectionUtil;
import com.shop.models.Offer;
import com.shop.util.Menu;

public class OfferDAOImpl implements OfferDAO {
	@Override
	public Integer create(Offer newEntry) {
		String sql = "insert into shop.offers (customer_id, item_id, amount, status, date_time) values (?, ?, ?, 0, ?) returning id;";
		int i = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newEntry.getCustomerId());
			ps.setInt(2, newEntry.getItemId());
			ps.setBigDecimal(3, newEntry.getAmount());
			ps.setTimestamp(4, new Timestamp(newEntry.getDateTime().getTime()));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				i = rs.getInt("id");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public Offer read(Integer primaryKey) {
		Offer o = null;
		String sql = "select * from shop.offers where id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, primaryKey);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				o = new Offer();
				o.setId(rs.getInt("id"));
				o.setAmount(rs.getBigDecimal("amount"));
				o.setCustomerId(rs.getInt("customer_id"));
				o.setDateTime(rs.getDate("date_time"));
				o.setItemId(rs.getInt("item_id"));
				o.setStatus(rs.getInt("status"));
				o.setHasPlan(rs.getBoolean("has_plan"));
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return o;
	}
	@Override
	public int delete(Integer primaryKey) {
		return primaryKey;
		// TODO Auto-generated method stub
	}
	@Override
	public int updateOfferStatus(Offer o, int status) {
		int a = 0;
		String sql = "update shop.offers set status = ? where id = ?";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, o.getId());
			a = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return a;
	}
	@Override
	public List<Offer> getOffersByStatusAndCustomerId(int status, int custId) {
		List<Offer> li = new ArrayList<Offer>();
		String sql = "select * from shop.offers where status = ? and customer_id = ? order by id";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, custId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Offer o = new Offer();
				o.setId(rs.getInt("id"));
				o.setAmount(rs.getBigDecimal("amount"));
				o.setCustomerId(rs.getInt("customer_id"));
				o.setDateTime(rs.getDate("date_time"));
				o.setItemId(rs.getInt("item_id"));
				o.setStatus(rs.getInt("status"));
				o.setHasPlan(rs.getBoolean("has_plan"));
				li.add(o);
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return li;
	}
	public List<Offer> getOffersByStatus(int status) {
		List<Offer> li = new ArrayList<Offer>();
		String sql = "select * from shop.offers where status = ? order by item_id, amount desc";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Offer o = new Offer();
				o.setId(rs.getInt("id"));
				o.setAmount(rs.getBigDecimal("amount"));
				o.setCustomerId(rs.getInt("customer_id"));
				o.setDateTime(rs.getDate("date_time"));
				o.setItemId(rs.getInt("item_id"));
				o.setStatus(rs.getInt("status"));
				o.setHasPlan(rs.getBoolean("has_plan"));
				li.add(o);
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return li;
	}
	public List<Offer> getOffersByItemId(int itemId) {
		List<Offer> li = new ArrayList<Offer>();
		String sql = "select * from shop.offers where item_id = ? order by id";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Offer o = new Offer();
				o.setId(rs.getInt("id"));
				o.setAmount(rs.getBigDecimal("amount"));
				o.setCustomerId(rs.getInt("customer_id"));
				o.setDateTime(rs.getDate("date_time"));
				o.setItemId(rs.getInt("item_id"));
				o.setStatus(rs.getInt("status"));
				o.setHasPlan(rs.getBoolean("has_plan"));
				li.add(o);
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return li;
	}
	public int updateOfferPaymentStatus(Offer o) {
		int a = 0;
		String sql = "update shop.offers set has_plan = ? where id = ?";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, o.getHasPlan());
			ps.setInt(2, o.getId());
			a = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return a;
	}
}