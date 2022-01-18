package com.linran.bean.selfconvert;

import org.springframework.core.convert.converter.Converter;

public class StudentConverter implements Converter<String, Student> {
	@Override
	public Student convert(String source) {
		Student student = new Student();
		student.setName("红河二中_"+source);
		return student;
	}
}
