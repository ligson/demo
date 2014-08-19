package org.ligson.designmode.creation.abstractfactory;

public class Farm4Pig implements Farm4 {
	public Animal produce() {
		return new Pig();
	}
}
