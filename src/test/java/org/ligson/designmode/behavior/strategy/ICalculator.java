package org.ligson.designmode.behavior.strategy;

/**
 * @author liuzhongbing
 * 计算器接口类
 */
public interface ICalculator {
	/**
	 * 计算表达式接口
	 * @param expression 待计算的表达式
	 * @return 计算结果
	 */
	public int calculate(String expression);
}
