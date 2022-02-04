package com.linran.bean.tx.xml.service;

import com.linran.bean.tx.xml.dao.BookDao;

public class BookService {
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

	public void updateTime(int id) {
		bookDao.updateTime(id);
	}
}
