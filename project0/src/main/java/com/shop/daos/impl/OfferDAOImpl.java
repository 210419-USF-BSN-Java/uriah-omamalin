package com.shop.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.shop.daos.OfferDAO;
import com.shop.dbutil.ConnectionUtil;
import com.shop.models.Offer;

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
			ps.setTimestamp(4, new Timestamp(newEntry.getDate().getTime()));
			
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
		// TODO Auto-generated method stub
		return null;
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