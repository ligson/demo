package org.ligson.designmode.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object proxyed;
    
    // 被代理对象
    public DynamicProxy(Object obj) {
        this.proxyed = obj;
    }
    
    // 代理调用
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result;
        // 方法调用之前
        System.out.println("start invoke!");

        // 调用原始对象的方法
        result = method.invoke(this.proxyed, args);

        // 方法调用之后
        System.out.println("end invoke!");
        return result;
    }
}
