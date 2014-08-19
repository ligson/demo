package org.ligson.designmode.structure.bridge;

/**
 * @author Administrator
 * 桥接具体类
 */
public class MyBridge extends Bridge {
	public void operation() {
		getSource().operation();
	}
}
