package org.ligson.designmode.behavior.visitor;

/**
 * @author liuzhongbing
 * 目标类接口
 */
public interface Subject {
	public void accept(Visitor visitor);
	public String getSubject();
}
