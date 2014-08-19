package org.ligson.designmode.behavior.interpreter;

public class Multiply implements Expression {

	public int interpret(Context context) {
		return context.getNum1() * context.getNum2();
	}
}
