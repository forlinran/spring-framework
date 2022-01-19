package com.linran.bean.factorymethod;

public class PersonInstantFactory {
	public Person getPerson(String name) {
		Person person = new Person("gopher");
		person.setName(name);
		return person;
	}

	public Person getPerson(String name, Long id) {
		Person person = new Person("gopher");
		person.setName(name);
		person.setId(id);
		return person;
	}
}
