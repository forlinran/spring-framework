package com.linran.bean.supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class GopherBFPP implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition gopherBD = beanFactory.getBeanDefinition("gopher");
		GenericBeanDefinition bd = (GenericBeanDefinition) gopherBD;
		bd.setInstanceSupplier(() -> {
			Gopher gopher = new Gopher();
			gopher.setName("鼹鼠");
			return gopher;
		});
	}
}
