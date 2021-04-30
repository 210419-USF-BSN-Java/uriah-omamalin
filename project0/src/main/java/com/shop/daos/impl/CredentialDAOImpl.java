package com.shop.daos.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.daos.CredentialDAO;
import com.shop.dbutil.ConnectionUtil;
import com.shop.models.Credential;
import com.shop.util.Menu;

public class CredentialDAOImpl implements CredentialDAO {
	@Override
	public Integer create(Credential newEntry) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Credential read(Integer primaryKey) {
		Credential cred = null;
		String sql = "select * from shop.credentials where id = ?";
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, primaryKey);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cred = new Credential();
				cred.setId(primaryKey);
				cred.setUserPass(rs.getString("user_pass"));
			}
		} catch (SQLException | IOException e) {
			Menu.errorln(e.getMessage());
		}
		return cred;
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