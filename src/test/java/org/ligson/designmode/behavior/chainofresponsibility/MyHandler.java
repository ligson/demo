package org.ligson.designmode.behavior.chainofresponsibility;

/**
 * @author liuzhongbing
 * 责任链实现类
 */
public class MyHandler extends AbstractHandler implements Handler {

	private String name;
	
	public MyHandler(String name) {
		this.name = name;
	}
	
	// 操作并调用责任链对象
	public void operation() {
		System.out.println(name + "处理代码");
		if (getChain() != null) {
			getChain().operation();
		}
	}
}
