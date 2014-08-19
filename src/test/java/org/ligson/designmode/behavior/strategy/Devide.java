package org.ligson.designmode.behavior.strategy;

/**
 * @author liuzhongbing
 * 除法计算类
 */
public class Devide extends AbstractCalculator implements ICalculator {
	public int calculate(String expression) {
		int arrayInt[] = split(expression, "/");
		return arrayInt[0] / arrayInt[1];
	}
}
