package org.ligson.designmode.creation.abstractfactory;

public class Farm4Cattle implements Farm4 {
	public Animal produce() {
		return new Cattle();
	}
}
