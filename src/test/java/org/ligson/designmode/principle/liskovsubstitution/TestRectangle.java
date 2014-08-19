package org.ligson.designmode.principle.liskovsubstitution;

public class TestRectangle {
	public void zoom(Rectangle rectangle, int width, int Height) {
		rectangle.setWidth(rectangle.getWidth() + width);
		rectangle.setHeight(rectangle.getHeight() + Height);
	}
}
