package com.shop.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.daos.PaymentDAO;
import com.shop.dbutil.ConnectionUtil;
import com.shop.models.Payment;
import com.shop.util.Menu;

public class PaymentDAOImpl implements PaymentDAO {
	@Override
	public Integer create(Payment newEntry) {
		String sql = "insert into shop.payments (offer_id, payment_plan, weekly_payment) values (?, ?, ?)";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newEntry.getOfferId());
			ps.setInt(2, newEntry.getPaymentPlan());
			ps.setBigDecimal(3, newEntry.getWeeklyPayment());
			ps.executeUpdate();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newEntry.getOfferId();
	}
	@Override
	public Payment read(Integer primaryKey) {
		Payment p = null;
		String sql = "select * from shop.payments where offer_id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, primaryKey);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Payment();
				p.setWeeklyPayment(rs.getBigDecimal("weekly_payment"));
				p.setOfferId(primaryKey);
				p.setPaymentPlan(rs.getInt("payment_plan"));
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return p;
	}
	@Override
	public int delete(Integer primaryKey) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Payment> getAllPaymnets() {
		List<Payment> li = new ArrayList<Payment>();
		String sql = "select * from shop.payments order by offer_id";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Payment p = new Payment();
				p.setOfferId(rs.getInt("offer_id"));
				p.setPaymentPlan(rs.getInt("payment_plan"));
				p.setWeeklyPayment(rs.getBigDecimal("weekly_payment"));
				li.add(p);
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return li;
	}
}