package org.ligson.designmode.principle.liskovsubstitution;

public class BastTest {
	public void zoom(Base base, int width, int height) {
		base.zoom(width, height);
	}
}
