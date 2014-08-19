package org.ligson.designmode.structure.bridge;

/**
 * @author Administrator
 * 桥接模式抽象类
 */
public abstract class Bridge {
	private Sourcable source;
	
	public Sourcable getSource() {
		return source;
	}

	public void setSource(Sourcable source) {
		this.source = source;
	}
	
	public void operation() {
		source.operation();
	}
}
