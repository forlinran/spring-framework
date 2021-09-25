package com.linran;

import com.linran.bean.Logo;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLearnTest {

	@Test
	public void injectTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Logo logoP = context.getBean(Logo.class);
		System.out.printf("this is logoP printf:%s%n",logoP.toString());
	}
}
