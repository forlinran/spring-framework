package com.linran.bean.selftag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * 自定义标签解析器
 */
public class StudentBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return Student.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		if (element.hasAttribute("id")) {
			builder.addPropertyValue("id", Long.valueOf(element.getAttribute("id")));
		}
		if (element.hasAttribute("name")) {
			builder.addPropertyValue("name", element.getAttribute("name"));
		}
		if (element.hasAttribute("email")) {
			builder.addPropertyValue("email", element.getAttribute("email"));
		}
		if (element.hasAttribute("hobby")) {
			builder.addPropertyValue("hobby", element.getAttribute("hobby"));
		}
	}
}
