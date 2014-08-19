package org.ligson.designmode.structure.adapter;

public class DefaultWrapperTest {

	public static void main(String[] args) {
		Sourcable source1 = new SourceSub1();
		Sourcable source2 = new SourceSub2();
		source1.operation1();
		source1.operation2();
		source2.operation1();
		source2.operation2();
	}
}
