package com.linran.bean.tx.annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

public class AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void accountBalance(BigDecimal bigDecimal) {
		String sql = "UPDATE account SET balance = balance - ? WHERE id = 1";
		jdbcTemplate.queryForObject(sql, BigDecimal.class, bigDecimal);
	}
}
