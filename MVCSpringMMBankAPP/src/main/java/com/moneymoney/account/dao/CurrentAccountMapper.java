package com.moneymoney.account.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.moneymoney.account.CurrentAccount;

public class CurrentAccountMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new CurrentAccount(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(6));
	}

}
