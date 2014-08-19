package org.ligson.designmode.behavior.templatemethod;

/**
 * @author liuzhongbing
 * 计算器抽象类
 */
public abstract class AbstractCalculator {
	
	public final int calculate(String expression, String deliString) {
		int arrayInt[] = split(expression, deliString);
		return calculate(arrayInt[0], arrayInt[1]);
	}
	
	abstract public int calculate(int num1, int num2);

	/**
	 * 根据计算表达式，提取待计算的数值
	 * @param expression 计算表达式
	 * @param deliString 分隔符
	 * @return 待计算数值的数组
	 */
	public int[] split(String expression, String deliString) {
		String array[] = expression.split(deliString);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
}
