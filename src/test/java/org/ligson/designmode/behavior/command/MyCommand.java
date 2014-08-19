package org.ligson.designmode.behavior.command;

/**
 * @author liuzhongbing
 * 命令实现类
 */
public class MyCommand implements Command {
	private Receiver receiver;

	public MyCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action();
	}
}
