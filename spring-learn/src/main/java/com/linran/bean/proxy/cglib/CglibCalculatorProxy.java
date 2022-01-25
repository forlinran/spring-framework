package com.linran.bean.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibCalculatorProxy implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("CglibCalculatorProxy diaoyong~");
		return methodProxy.invokeSuper(o, objects);
	}
}
