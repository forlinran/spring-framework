package com.linran.bean.tx.annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public int getPrice(int id) {
		String sql = "SELECT price FROM book WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateStock(int id) {
		String sql = "UPDATE book SET stock = stock - 1 WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Transactional(propagation = Propagation.NESTED)
	public void updateTime(int id) {
//		Integer stock = jdbcTemplate.queryForObject("SELECT stock FROM book WHERE id = ?", Integer.class, id);
		String sql = "UPDATE book SET utime = now() WHERE id = ?";
		jdbcTemplate.update(sql, id);
//		if (id == 1) {
//			throw new RuntimeException("内层事务回滚");
//		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public LocalDateTime getUpdateTime(int id) {
		LocalDateTime localDateTime = jdbcTemplate.queryForObject("SELECT utime FROM book WHERE id = ?", LocalDateTime.class, id);
		return localDateTime;
	}
}
