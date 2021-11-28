package com.linran.bean.selftag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 自定义命名空间Handler
 *  通过spring.handlers注册进容器
 */
public class LinranNamespaceHandler extends NamespaceHandlerSupport {

	/**
	 * 注册对应的parser，可以再结合接口中的注释理解
	 */
	@Override
	public void init() {
		//注册student标签
		registerBeanDefinitionParser("student", new StudentBeanDefinitionParser());
	}
}
