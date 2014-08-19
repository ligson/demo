package org.ligson.designmode.behavior.visitor;

/**
 * @author liuzhongbing
 * 目标类
 */
public class MySubject implements Subject {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public String getSubject() {
		return "这是一个主题";
	}
}
