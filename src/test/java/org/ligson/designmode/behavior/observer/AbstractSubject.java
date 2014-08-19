package org.ligson.designmode.behavior.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author liuzhongbing
 * 被观察者抽象类
 */
public abstract class AbstractSubject implements Subject {
	private Vector<Observer> vect = new Vector<Observer>();
	
	@Override
	public void attach(Observer observer) {
		vect.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		vect.remove(observer);
	}

	@Override
	public void notifyObservers() {
		Enumeration<Observer> em = vect.elements();
		while (em.hasMoreElements()) {
			em.nextElement().update();
		}
	}

}
