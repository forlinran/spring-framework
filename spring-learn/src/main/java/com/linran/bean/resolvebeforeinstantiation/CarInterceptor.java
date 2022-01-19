package com.linran.bean.resolvebeforeinstantiation;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CarInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("CarInterceptor动态拦截前 methodName:" + method.getName());
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("CarInterceptor动态拦截后 methodName:" + method.getName());
		return result;
	}
}
