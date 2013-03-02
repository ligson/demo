package demo.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodInvokeAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Object pObject = invocation.getThis();
		Method method = invocation.getMethod();

		Class<?>[] class1 = method.getParameterTypes();
		String types = "";
		for (int i = 0; i < class1.length; i++) {
			if (i == class1.length - 1) {
				types += (class1[i].getSimpleName() + " arg" + i);
			} else {
				types += (class1[i].getSimpleName() + " arg" + i + ",");
			}
		}
		System.out.println("正在调用方法：" + pObject.getClass().getName() + "."
				+ method.getName() + "(" + types + ")");
		Object object = invocation.proceed();
		return object;
	}

}
