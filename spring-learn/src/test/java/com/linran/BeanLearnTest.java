package com.linran;

import com.linran.bean.Logo;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLearnTest {

	@Test
	public void injectTest() {
//      注释掉的代码在getEnvironment().resolveRequiredPlaceholders的时候会进行placeholder解析
//		System.setProperty("spring", "classpath");
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("${spring}:config.xml");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		Logo logoP = context.getBean(Logo.class);
		System.out.printf("this is logoP printf:%s%n",logoP.toString());
	}
}
