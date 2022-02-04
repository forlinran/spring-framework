package com.linran.bean.tx.annotation.service;

import com.linran.bean.tx.annotation.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class BookService {

	@Autowired
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public int getPrice(int id) {
		return bookDao.getPrice(id);
	}

	public void updateStock(int id) {
		bookDao.updateStock(id);
	}

	@Transactional
	public void updateTime(int id) {
		bookDao.updateTime(id);
	}

	@Transactional
	public void nestSql(int id) {
		bookDao.updateStock(id);
		try {
			bookDao.updateTime(id);
		} catch (Exception e) {
			System.out.println("捕获异常." + e.toString());
		}
		LocalDateTime updateTime = bookDao.getUpdateTime(id);
		if (id == 1) {
//			throw new RuntimeException("外层事务回滚");
		}
		System.out.printf("当前时间%s %n", updateTime.toString());
	}
}
