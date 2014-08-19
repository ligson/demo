package org.ligson.designmode.behavior.mediator;

public class MyUser2 extends User {
	
	public MyUser2(Mediator mediator) {
		super(mediator);
	}
	
	public void work() {
		System.out.println("User2执行");
	}
}
