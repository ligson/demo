package org.ligson.designmode.behavior.observer;

/**
 * @author liuzhongbing
 * 具体观察者
 */
public class Observer1 implements Observer {
	public void update() {
		System.out.println("观察者1得到通知！");
	}
}
