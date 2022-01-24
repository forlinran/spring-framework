package com.linran.bean.proxy.jdk;

public class MyCalculator implements ICalculator {
	@Override
	public void add(int i, int j) {
		int result = i + j;
		System.out.println("目标方法add(int)执行了");
	}

	@Override
	public void sub(int i, int j) {
		int result = i - j;
		System.out.println("目标方法sub执行了");
	}

	@Override
	public void multi(int i, int j) {
		int result = i * j;
		System.out.println("目标方法mult执行了");
	}

	@Override
	public void div(int i, int j) {
		int result = i / j;
		System.out.println("目标方法div执行了");
	}
}
