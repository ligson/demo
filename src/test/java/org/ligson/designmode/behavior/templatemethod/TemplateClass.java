package org.ligson.designmode.behavior.templatemethod;

public abstract class TemplateClass {
	public void templateMethod() {
		operation1();
		operation2();
		operation3();
	}
	
	abstract public void operation1();
	abstract public void operation2();
	abstract public void operation3();
}
