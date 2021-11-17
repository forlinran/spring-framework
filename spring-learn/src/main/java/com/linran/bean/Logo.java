package com.linran.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Logo implements BeanNameAware, ApplicationContextAware {
	private String name = "panda";

	public void initMethod() {
		System.out.println("自定义初始化方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Logo{" +
				"name='" + name + '\'' +
				'}';
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("beanName" + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		applicationContext.getEnvironment().getProperty("sss");
	}
}
