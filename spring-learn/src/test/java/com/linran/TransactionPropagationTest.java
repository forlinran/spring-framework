package com.linran;

import com.linran.bean.tx.annotation.config.TransactionConfig;
import com.linran.bean.tx.annotation.dao.BookDao;
import com.linran.bean.tx.annotation.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 事务传播行为测试
 * 事务方法A调用事务方法B,反应得事务方法B的事务行为
 */
public class TransactionPropagationTest {

	@Test
	public void singleTransaction() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TransactionConfig.class);
		context.refresh();
		BookDao bookDao = context.getBean(BookDao.class);
		bookDao.updateTime(1);
	}

	/**
	 * 事务内嵌nest
	 * 如果内层事务方法有进行catch
	 * 1.内层嵌套事务发生异常，则仅回滚内嵌事务；回退到保存点
	 * 2.外层事务发生异常，则嵌套事务跟随外层事务一起回滚
	 *
	 * 内外层事务能够相互访问，同一链接
	 */
	@Test
	public void buyBook() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TransactionConfig.class);
		context.refresh();
		BookService bookService = context.getBean(BookService.class);
		bookService.nestSql(1);
	}
}
