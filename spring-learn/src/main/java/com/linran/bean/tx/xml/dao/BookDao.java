package com.linran.bean.tx.xml.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getPrice(int id) {
		String sql = "SELECT price FROM book WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, id);
	}

	public void updateStock(int id) {
		String sql = "UPDATE book SET stock = stock - 1 WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	public void updateTime(int id) {
		String sql = "UPDATE book SET utime = now() WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
