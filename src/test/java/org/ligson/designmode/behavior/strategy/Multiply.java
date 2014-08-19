package org.ligson.designmode.behavior.strategy;

/**
 * @author liuzhongbing
 * 乘法计算类
 */
public class Multiply extends AbstractCalculator implements ICalculator {
	public int calculate(String expression) {
		int arrayInt[] = split(expression, "\\*");
		return arrayInt[0] * arrayInt[1];
	}
}
