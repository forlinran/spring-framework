package com.linran.bean.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkCalculatorProxy {
	public static ICalculator getProxy(final MyCalculator calculator) {
		ClassLoader loader = calculator.getClass().getClassLoader();
		Class<?>[] interfaces = calculator.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("JdkCalculatorProxy zengqianglei~");
				Object result = null;
				try {
					result = method.invoke(calculator, args);
				} catch (Exception e) {

				}
				return result;
			}
		};
		Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
		return (ICalculator) proxy;
	}
}
