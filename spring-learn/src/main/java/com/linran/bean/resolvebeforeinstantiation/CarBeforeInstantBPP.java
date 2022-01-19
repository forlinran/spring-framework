package com.linran.bean.resolvebeforeinstantiation;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

public class CarBeforeInstantBPP implements InstantiationAwareBeanPostProcessor {

	//实例化之前
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.printf("beanName:%s 执行CarBeforeInstantBPP#postProcessBeforeInstantiation", beanName);
		if (beanClass == Car.class) {
			// 对Car执行动态代理
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(Car.class);
			enhancer.setCallback(new CarInterceptor());
			System.out.println("创建代理对象 CarInterceptor");
			return enhancer.create();
		}
		return null;
	}

	//实例化之后
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.printf("beanName:%s 执行CarBeforeInstantBPP#postProcessAfterInstantiation", beanName);
		return false;
	}

	//初始化之前
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.printf("beanName:%s 执行CarBeforeInstantBPP#postProcessBeforeInitialization", beanName);
		return bean;
	}

	//初始化之后
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.printf("beanName:%s 执行CarBeforeInstantBPP#postProcessAfterInitialization", beanName);
		return bean;
	}

	//属性填充
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		System.out.printf("beanName:%s 执行CarBeforeInstantBPP#postProcessProperties", beanName);
		return pvs;
	}
}
