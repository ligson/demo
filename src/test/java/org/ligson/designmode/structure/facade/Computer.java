package org.ligson.designmode.structure.facade;

/**
 * @author liuzhongbing
 * 外观模式
 */
public class Computer {
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	
	public Computer() {
		cpu = new CPU();
		memory = new Memory();
		disk = new Disk();
	}
	
	public void startup() {
		System.out.println("开始启动计算机");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("启动计算机完成");
	}
	
	public void shutdown() {
		System.out.println("开始关闭计算机");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("关闭计算机完成");		
	}
}
