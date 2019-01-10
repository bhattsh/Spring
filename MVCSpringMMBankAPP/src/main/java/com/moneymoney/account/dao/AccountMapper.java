package com.moneymoney.account.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moneymoney.account.SavingsAccount;

public class AccountMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new SavingsAccount(rs.getInt(1),rs.getString(2),rs.getDouble(3), rs.getBoolean(4));
	}

}
