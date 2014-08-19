package org.ligson.designmode.behavior.state;

/**
 * @author liuzhongbing
 * 状态类
 */
public class State {
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void operation1() {
		System.out.println("执行操作1");
	}
	
	public void operation2() {
		System.out.println("执行操作2");
	}
}
