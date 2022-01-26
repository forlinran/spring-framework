package com.linran.bean.aop.xml;

public class MathCalculator {
	public void add(int i, int j) {
		int result = i + j;
		System.out.println("目标方法add(int)执行了");
	}

	public void sub(int i, int j) {
		int result = i - j;
		System.out.println("目标方法sub执行了");
	}

	public void multi(int i, int j) {
		int result = i * j;
		System.out.println("目标方法mult执行了");
	}

	public void div(int i, int j) {
		int result = i / j;
		System.out.println("目标方法div执行了");
	}
}
