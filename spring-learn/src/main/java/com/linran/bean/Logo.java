package com.linran.bean;

import org.springframework.beans.factory.BeanNameAware;

public class Logo implements BeanNameAware {
	private String name = "panda";

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
}
