package demo.aop.advice;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import demo.action.LoginAction;

public class MyAop {
	
	private static Log log = LogFactory.getLog(MyAop.class);
	public void before(JoinPoint jp) {
		Object[] args = jp.getArgs();
		StringBuffer buffer = new StringBuffer();
		buffer.append("调用方法之前:");
		buffer.append(jp.getTarget().getClass().getName());
		buffer.append(".");
		buffer.append(jp.getSignature().getName());
		buffer.append("(");
		for(Object object:args){
			buffer.append(object.getClass().getSimpleName());
			buffer.append(",");
		}
		buffer.deleteCharAt(buffer.length()-1);
		buffer.append(")");
		log.debug(buffer.toString());
		
		//动态注入参数
		Object object = jp.getTarget();
		if(object instanceof LoginAction){
			//LoginAction loginAction = (LoginAction) object;
			//loginAction.setName("ligson");
			//loginAction.setPassword("password");
		}
	}

	public void after(JoinPoint jp) {
		Object[] args = jp.getArgs();
		StringBuffer buffer = new StringBuffer();
		buffer.append("调用方法之后:");
		buffer.append(jp.getTarget().getClass().getName());
		buffer.append(".");
		buffer.append(jp.getSignature().getName());
		buffer.append("(");
		for(Object object:args){
			buffer.append(object.getClass().getSimpleName());
			buffer.append(",");
		}
		buffer.deleteCharAt(buffer.length()-1);
		buffer.append(")");
		log.debug(buffer.toString());
	}

	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.nanoTime();
		Object retVal = pjp.proceed();
		time = System.nanoTime() - time;
		log.debug("方法调用时间: " + (time/1000.000) + " ms");
		return retVal;
	}
}
