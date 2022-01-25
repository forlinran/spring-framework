package com.linran.bean.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Test {
	public static void main(String[] args) {
		//动态代理创建的class文件存储到本地
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "f:\\code");
		// 通过cglib动态代理获取代理对象的过程，创建调用的对象 ClassLoaderData 打个断点，创建EnhancerKey(KeyFactory)
		Enhancer enhancer = new Enhancer();
		//设置enhancer对象的父类
		enhancer.setSuperclass(MyCalculator.class);
		//设置enhancer的回调对象
		enhancer.setCallback(new CglibCalculatorProxy());
		//创建代理对象 打个断点
		MyCalculator myCalculator = (MyCalculator) enhancer.create();
		//通过代理对象调用目标方法
		myCalculator.add(1, 1);
		System.out.println(myCalculator.getClass());
	}
}
