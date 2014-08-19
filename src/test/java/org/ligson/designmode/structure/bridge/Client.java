package org.ligson.designmode.structure.bridge;

public class Client {

	public static void main(String[] args) {
		// 创建桥对象
		Bridge bridge = new MyBridge();
		
		// 调用第一个对象
		Sourcable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.operation();
		
		// 调用第二个对象
		Sourcable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.operation();
	}
}
