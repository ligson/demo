package org.ligson.designmode.behavior.strategy;

public class Test {

	public static void main(String[] args) {
		while (true) {
			// 接收表达式输入
			System.out.println("准备输入：");
			String expression = System.console().readLine();
			
			// 初始化实例
			ICalculator calculator;
			if (expression.indexOf("+") != -1) {
				calculator = new Plus();
			} else if (expression.indexOf("-") != -1) {
				calculator = new Minus();
			} else if (expression.indexOf("*") != -1) {
				calculator = new Multiply();
			} else if (expression.indexOf("/") != -1) {
				calculator = new Devide();
			} else {
				calculator = new Default();
			}
			
			// 开始运算
			int value = calculator.calculate(expression);
			System.out.println("="+value);
		}
	}
}
