package com.linran.bean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBeanObject implements FactoryBean<Bird> {
	@Override
	public Bird getObject() throws Exception {
		Bird bird = new Bird();
		bird.setName("bird");
		bird.setMark("factoryBean自定义的bean，自己控制(非spring管理)，更加灵活");
		return bird;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}
}
