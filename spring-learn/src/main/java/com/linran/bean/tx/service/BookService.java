package com.linran.bean.tx.service;

import com.linran.bean.tx.dao.BookDao;

public class BookService {
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
