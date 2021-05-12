package com.revature.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	@Override
	public void create(Reimbursement t) {
		String sql = "insert into ers.reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id) "
				   + "values (?, ?, ?, ?, ?, 1, ?)";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setBigDecimal(1, t.getReimbAmount());
			ps.setTimestamp(2, new Timestamp(t.getReimbSubmitted().getTime()));
			ps.setString(3, t.getReimbDescription());
			ps.setBinaryStream(4, t.getReimbReceipt());
			ps.setInt(5, t.getReimbAuthor());
			ps.setInt(6, t.getReimbTypeId());
			
			ps.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Reimbursement readOne(Integer pk) {
		Reimbursement r = null;
		String sql = "select * from ers.reimbursement where reimb_id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = new Reimbursement();
				
				r.setReimbAmount(rs.getBigDecimal("reimb_amount"));
				r.setReimbAuthor(rs.getInt("reimb_author"));
				r.setReimbDescription(rs.getString("reimb_description"));
				r.setReimbId(pk);
				r.setReimbReceipt(rs.getBinaryStream("reimb_receipt"));
				r.setReimbResolved(rs.getDate("reimb_resolved"));
				r.setReimbResolver(rs.getInt("reimb_resolver"));
				r.setReimbStatusId(rs.getInt("reimb_status_id"));
				r.setReimbSubmitted(rs.getDate("reimb_submitted"));
				r.setReimbTypeId(rs.getInt("reimb_type_id"));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return r;
	}
	@Override
	public List<Reimbursement> readAll() {
		List<Reimbursement> li = new ArrayList<Reimbursement>();
		String sql = "select * from ers.reimbursement";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				
				r.setReimbAmount(rs.getBigDecimal("reimb_amount"));
				r.setReimbAuthor(rs.getInt("reimb_author"));
				r.setReimbDescription(rs.getString("reimb_description"));
				r.setReimbId(rs.getInt("reimb_id"));
				r.setReimbReceipt(rs.getBinaryStream("reimb_receipt"));
				r.setReimbResolved(rs.getDate("reimb_resolved"));
				r.setReimbResolver(rs.getInt("reimb_resolver"));
				r.setReimbStatusId(rs.getInt("reimb_status_id"));
				r.setReimbSubmitted(rs.getDate("reimb_submitted"));
				r.setReimbTypeId(rs.getInt("reimb_type_id"));
				
				li.add(r);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return li;
	}
	@Override
	public void update(Reimbursement t) {
		// TODO Auto-generated method stub
	}
	@Override
	public void deleteByObject(Reimbursement t) {
		// TODO Auto-generated method stub
	}
	@Override
	public void deleteById(Integer pk) {
		// TODO Auto-generated method stub
	}
	@Override
	public List<Reimbursement> getResolvedReimbursements() {
		List<Reimbursement> li = new ArrayList<Reimbursement>();
		String sql = "select * from ers.reimbursement where reimb_status_id != 1";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				
				r.setReimbAmount(rs.getBigDecimal("reimb_amount"));
				r.setReimbAuthor(rs.getInt("reimb_author"));
				r.setReimbDescription(rs.getString("reimb_description"));
				r.setReimbId(rs.getInt("reimb_id"));
				r.setReimbReceipt(rs.getBinaryStream("reimb_receipt"));
				r.setReimbResolved(rs.getDate("reimb_resolved"));
				r.setReimbResolver(rs.getInt("reimb_resolver"));
				r.setReimbStatusId(rs.getInt("reimb_status_id"));
				r.setReimbSubmitted(rs.getDate("reimb_submitted"));
				r.setReimbTypeId(rs.getInt("reimb_type_id"));
				
				li.add(r);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return li;
	}
	@Override
	public List<Reimbursement> getPendingReimbursements() {
		List<Reimbursement> li = new ArrayList<Reimbursement>();
		String sql = "select * from ers.reimbursement where reimb_status_id = 1";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				
				r.setReimbAmount(rs.getBigDecimal("reimb_amount"));
				r.setReimbAuthor(rs.getInt("reimb_author"));
				r.setReimbDescription(rs.getString("reimb_description"));
				r.setReimbId(rs.getInt("reimb_id"));
				r.setReimbReceipt(rs.getBinaryStream("reimb_receipt"));
				r.setReimbResolved(rs.getDate("reimb_resolved"));
				r.setReimbResolver(rs.getInt("reimb_resolver"));
				r.setReimbStatusId(rs.getInt("reimb_status_id"));
				r.setReimbSubmitted(rs.getDate("reimb_submitted"));
				r.setReimbTypeId(rs.getInt("reimb_type_id"));
				
				li.add(r);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return li;
	}
}