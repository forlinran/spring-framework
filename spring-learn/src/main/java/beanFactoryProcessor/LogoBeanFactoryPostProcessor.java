package beanFactoryProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class LogoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//可以在实例化前替换class值
//		BeanDefinition logoP = beanFactory.getBeanDefinition("logoP");
//		logoP.setBeanClassName("xxx.xxx");
		System.out.println("beanFactory增强");
	}
}
