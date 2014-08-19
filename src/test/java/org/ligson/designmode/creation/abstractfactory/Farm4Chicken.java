package org.ligson.designmode.creation.abstractfactory;

public class Farm4Chicken implements Farm4 {
	public Animal produce() {
		return new Chicken();
	}
}
