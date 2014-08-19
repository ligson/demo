package org.ligson.designmode.behavior.observer;

/**
 * @author liuzhongbing
 * 具体观察者
 */
public class Observer2 implements Observer {
	public void update() {
		System.out.println("观察者2得到通知！");
	}
}
