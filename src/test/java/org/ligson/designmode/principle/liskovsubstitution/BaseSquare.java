package org.ligson.designmode.principle.liskovsubstitution;

public class BaseSquare extends Base {
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	public void setHeight(int height) {
		super.setWidth(height);
		super.setHeight(height);
	}
	
	public void zoom(int width, int height) {
		int length = (width + height) /2;
		setWidth(getWidth() + length);
		setHeight(getHeight() + length);
	}
}
