package demo.aop.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;


public class ExceptionHandler implements ThrowsAdvice {
	/*
	 * public void afterThrowing(Throwable subclassOfThrowable) {
	 * 
	 * }
	 */
	private static Log log = LogFactory.getLog(ExceptionHandler.class);
	public void afterThrowing(Method method, Object[] args, Object target,
			Throwable subclassOfThrowable) {
		log.debug(target.getClass().getName() + "." + method.getName()
				+ "() throw a exception:" + subclassOfThrowable.getMessage());
		subclassOfThrowable.printStackTrace();
	}

}
