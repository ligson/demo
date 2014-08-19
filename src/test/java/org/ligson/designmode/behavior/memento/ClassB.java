package org.ligson.designmode.behavior.memento;

public class ClassB {
	private Memento memento;
	
	public ClassB(Memento memento) {
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
