package com.linran.bean.factorymethod;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	private Long id;
	private String name;

	public Person() {
	}

//	@Autowired
//	public Person(Long id) {
//		this.id = id;
//	}

	@Autowired
	public Person(String name) {
		this.name = name;
	}

//	@Autowired
	public Person(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
