package com.linran.bean.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;
import java.util.List;


//@Aspect
//@Configuration
//@EnableAspectJAutoProxy
public class LogAspect {

	@Pointcut("execution(* com.linran.bean.aop.MathCalculator.*(..))")
	public void logPintCut() {
	}

	//	@Before("logPintCut()")
	public void showBeginLog(JoinPoint jPoint) {
		Object[] args = jPoint.getArgs();//获取方法参数
		List<Object> asList = Arrays.asList(args);//转化成List集合
		Signature signature = jPoint.getSignature();
		String name = signature.getName();//获取方法的名字
		System.out.println("LogAspectp1-----AOP日志开始");
		System.out.println("目标方法名：" + name + "，参数列表：" + asList);
	}

	//	@After("logPintCut()")
	public void showAfterLog() {
		System.out.println("LogAspectp1-----AOP方法结束");
	}

	//	@AfterThrowing(value = "logPintCut()", throwing = "ex")
	public void showExceptionLog(Exception ex) {
		System.out.println("LogAspectp1-----AOP方法异常");
		System.out.println("异常信息:" + ex.getMessage());
	}

	//	@AfterReturning(value = "pointCut()", returning = "result")
	public void showReturnLog(Object result) {
		System.out.println("方法返回值:" + result);
		System.out.println("LogAspectp1-----AOP方法最终返回");
	}

	public Object showLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("around advice before:show log...");
		Object ret = proceedingJoinPoint.proceed();
		System.out.println("around advice after:show log...");
		return ret;
	}
}
