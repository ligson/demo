package org.ligson.designmode.behavior.interpreter;

public class Test {

	public static void main(String[] args) {
		// 计算：(10 + 5 - 3) * 2 / 6 = 4
		int result = 
		new Devide().interpret(new Context(
			new Multiply().interpret(new Context(
					new Minus().interpret(new Context(
							new Plus().interpret(new Context(10, 5)),
					3)),
			2)),
		6));
		System.out.println("(10 + 5 - 3) * 2 / 6 = " + result);
	}
}
