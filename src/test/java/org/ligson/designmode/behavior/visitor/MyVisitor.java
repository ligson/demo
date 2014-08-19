package org.ligson.designmode.behavior.visitor;

/**
 * @author liuzhongbing
 * 访问者实现类类
 */
public class MyVisitor implements Visitor {
	public void visit(Subject subject) {
		System.out.println("访问了主题：" + subject.getSubject());
	}
}
