package com.linran.bean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {

//	@Autowired
	@Lin
	private ClassRoom room;

	public void hello() {
		room.hello();
	}
}
