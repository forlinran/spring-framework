package com.linran.bean;

public class Logo {
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
}
