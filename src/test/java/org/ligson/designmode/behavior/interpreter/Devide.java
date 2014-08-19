package org.ligson.designmode.behavior.interpreter;

public class Devide implements Expression {

	public int interpret(Context context) {
		return context.getNum1() / context.getNum2();
	}
}
