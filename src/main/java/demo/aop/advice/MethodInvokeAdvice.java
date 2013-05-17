package demo.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MethodInvokeAdvice implements MethodInterceptor {

	private static Log log = LogFactory.getLog(MethodInvokeAdvice.class);
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
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("正在调用方法：");
		buffer.append(pObject.getClass().getName());
		buffer.append(".");
		buffer.append(method.getName());
		buffer.append("(" + types + ")");
		
		log.debug(buffer);
		Object object = invocation.proceed();
		return object;
	}

}
