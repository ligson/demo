package org.ligson.designmode.creation.abstractfactory;

public class Farm4Sheep implements Farm4 {
	public Animal produce() {
		return new Sheep();
	}
}
