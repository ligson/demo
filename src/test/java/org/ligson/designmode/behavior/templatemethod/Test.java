package org.ligson.designmode.behavior.templatemethod;

public class Test {

	public static void main(String[] args) {
		while (true) {
			// 接收表达式输入
			System.out.println("准备输入：");
			String expression = System.console().readLine();
			
			// 初始化实例
			AbstractCalculator calculator;
			String deliString = " ";
			if (expression.indexOf("+") != -1) {
				calculator = new Plus();
				deliString = "\\+";
			} else if (expression.indexOf("-") != -1) {
				calculator = new Minus();
				deliString = "\\-";
			} else if (expression.indexOf("*") != -1) {
				calculator = new Multiply();
				deliString = "\\*";
			} else if (expression.indexOf("/") != -1) {
				calculator = new Devide();
				deliString = "\\/";
			} else {
				calculator = new Default();
			}
			
			// 开始运算
			int value = calculator.calculate(expression, deliString);
			System.out.println("="+value);
		}
	}
}
