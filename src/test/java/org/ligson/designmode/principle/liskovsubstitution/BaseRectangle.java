package org.ligson.designmode.principle.liskovsubstitution;

public class BaseRectangle extends Base {
	public void zoom(int width, int height) {
		setWidth(getWidth() + width);
		setHeight(getHeight() + height);
	}
}
