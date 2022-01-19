package com.linran.bean.factorymethod;

public class PersonStaticFactory {
	public static Person getPerson(String name) {
		Person person = new Person("gopher");
		person.setName(name);
		return person;
	}
}
