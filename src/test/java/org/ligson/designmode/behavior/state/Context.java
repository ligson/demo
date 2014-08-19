package org.ligson.designmode.behavior.state;

/**
 * @author liuzhongbing
 * 状态切换类
 */
public class Context {
	private State state;
	
	public Context(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void operation() {
		if (state.getValue().equals("type1")) {
			state.operation1();
		} else if (state.getValue().equals("type2")) {
			state.operation2();
		}
	}
}
