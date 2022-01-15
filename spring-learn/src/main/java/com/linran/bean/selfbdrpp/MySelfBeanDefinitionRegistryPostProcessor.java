package com.linran.bean.selfbdrpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;

public class MySelfBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

	private String name;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("调用MySelfBeanDefinitionRegistryPostProcessor#postProcessBeanFactory");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("调用MySelfBeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry");
	}

	@Override
	public int getOrder() {
		return 0;
	}

	public void setName(String name) {
		this.name = name;
	}
}