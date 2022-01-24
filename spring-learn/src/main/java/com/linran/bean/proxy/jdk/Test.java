package com.linran.bean.proxy.jdk;

public class Test {
	public static void main(String[] args) {
		// 生成的class文件保存到本地
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		ICalculator proxy = JdkCalculatorProxy.getProxy(new MyCalculator());
		proxy.add(1, 1);
		System.out.println(proxy.getClass());
	}
}
