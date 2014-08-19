package org.ligson.designmode.behavior.chainofresponsibility;

public class Test {

	public static void main(String[] args) {
		MyHandler handler1 = new MyHandler("handler1");
		MyHandler handler2 = new MyHandler("handler2");
		// 设置链接
		handler1.setChain(handler2);
		MyHandler handler3 = new MyHandler("handler3");
		// 设置链接
		handler2.setChain(handler3);
		handler1.operation();
	}
}
