package org.ligson.designmode.behavior.strategy;

/**
 * @author liuzhongbing
 * 减法计算类
 */
public class Minus extends AbstractCalculator implements ICalculator {
	public int calculate(String expression) {
		int arrayInt[] = split(expression, "-");
		return arrayInt[0] - arrayInt[1];
	}
}
