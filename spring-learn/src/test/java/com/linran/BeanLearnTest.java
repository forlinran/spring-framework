package com.linran;

import com.linran.bean.Bird;
import com.linran.bean.CircleA;
import com.linran.bean.CircleB;
import com.linran.bean.Logo;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

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

	@Test
	public void circleDependencyTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		CircleA circleA = context.getBean(CircleA.class);
		CircleB circleB = context.getBean(CircleB.class);
		System.out.printf("this is circleA printf:%s%n",circleA.toString());
		System.out.printf("this is circleB printf:%s%n",circleB.toString());
	}

	/**
	 * 都是用来创建对象的
	 * 当使用BeanFactory的时候必须要遵循完整的创建过程，这个过程是由spring来管理控制的
	 * 而使用FactoryBean只需要调用getObject就可以返回具体的对象，整个对象的创建过程是由用户自己来控制，更加灵活
	 */
	@Test
	public void factoryBeanTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		//容器创建好后，容器中是没有Bird对象，但是会有myFactoryBeanObject对象，在实际调用getBean的时候先获取对应的FactoryBean对象，然后再是执行getObject对象
		Bird bird = (Bird) context.getBean("myFactoryBeanObject");
		System.out.println(bird);
	}
}
