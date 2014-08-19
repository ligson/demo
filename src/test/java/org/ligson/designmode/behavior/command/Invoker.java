package org.ligson.designmode.behavior.command;

/**
 * @author liuzhongbing
 * 命令调用者
 */
public class Invoker {
	// 命令
	private Command command;
	
	public Invoker(Command command) {
		this.command = command;
	}
	
	// 执行命令
	public void action() {
		command.execute();
	}
}
