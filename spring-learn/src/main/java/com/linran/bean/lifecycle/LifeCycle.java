package com.linran.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycle implements ApplicationContextAware {

	@PostConstruct
	public void init() {
		System.out.println("初始化.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("销毁方法.");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("applicationContextAware方法调用了");
	}
}
