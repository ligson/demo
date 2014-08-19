package org.ligson.designmode.behavior.mediator;

public class MyUser1 extends User {
	
	public MyUser1(Mediator mediator) {
		super(mediator);
	}
	
	public void work() {
		System.out.println("User1执行");
	}
}
