package org.ligson.designmode.behavior.chainofresponsibility;

/**
 * @author liuzhongbing
 * 责任链抽象类
 */
public abstract class AbstractHandler {
	// 定义责任链对象
	private Handler chain;

	public Handler getChain() {
		return chain;
	}

	public void setChain(Handler chain) {
		this.chain = chain;
	}
}
