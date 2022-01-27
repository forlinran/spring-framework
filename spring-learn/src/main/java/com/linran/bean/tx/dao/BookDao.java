package com.linran.bean.tx.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
