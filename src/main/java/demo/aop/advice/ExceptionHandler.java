package demo.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionHandler implements ThrowsAdvice {
	/*
	 * public void afterThrowing(Throwable subclassOfThrowable) {
	 * 
	 * }
	 */

	public void afterThrowing(Method method, Object[] args, Object target,
			Throwable subclassOfThrowable) {
		System.out.println(target.getClass().getName() + "." + method.getName()
				+ "() throw a exception:" + subclassOfThrowable.getMessage());
		subclassOfThrowable.printStackTrace();
	}

}
