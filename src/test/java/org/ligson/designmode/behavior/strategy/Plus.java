package org.ligson.designmode.behavior.strategy;

/**
 * @author liuzhongbing
 * 加法计算类
 */
public class Plus extends AbstractCalculator implements ICalculator {
	public int calculate(String expression) {
		int arrayInt[] = split(expression, "\\+");
		return arrayInt[0] + arrayInt[1];
	}
}
