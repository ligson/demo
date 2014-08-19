package org.ligson.designmode.behavior.observer;

/**
 * @author liuzhongbing
 * 具体被观察者
 */
public class MySubject extends AbstractSubject {
	public void operation() {
		System.out.println("修改自己");
		// 通知观察者
		notifyObservers();
	}
}
