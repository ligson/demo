package org.ligson.designmode.behavior.observer;

/**
 * @author liuzhongbing
 * 被观察者接口
 */
public interface Subject {
	// 增加观察者
	public void attach(Observer observer);
	// 删除观察者
	public void detach(Observer observer);
	// 通知所有观察者
	public void notifyObservers();
	// 自身的操作接口
	public void operation();
}
