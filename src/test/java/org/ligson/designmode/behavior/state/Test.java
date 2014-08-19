package org.ligson.designmode.behavior.state;

public class Test {

	public static void main(String[] args) {
		State state = new State();
		Context context = new Context(state);
		
		// 设置第一种状态
		state.setValue("type1");
		context.operation();
		
		// 设置第二种状态
		state.setValue("type2");
		context.operation();
	}
}
