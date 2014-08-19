package org.ligson.designmode.behavior.iterator;

public class MyIterator implements Iterator {
	private Collection collection;
	private int pos = -1;

	public MyIterator(Collection collection) {
		this.collection = collection;
	}

	// 第一个
	public Object first() {
		pos = 0;
		return collection.get(pos);
	}

	// 第一个
	public boolean isFirst() {
		if (pos == 0) {
			return true;
		} else {
			return false;
		}
	}

	// 最后一个
	public Object last() {
		pos = collection.size() - 1;
		return collection.get(pos);
	}

	// 最后一个
	public boolean isLast() {
		if (pos == collection.size() - 1) {
			return true;
		} else {
			return false;
		}
	}

	// 后移
	public Object next() {
		if (pos < collection.size() - 1) {
			pos++;
		}
		return collection.get(pos);
	}

	// 后移
	public boolean hasNext() {
		if (pos < collection.size() - 1) {
			return true;
		} else {
			return false;
		}
	}

	// 前移
	public Object previous() {
		if (pos > 0) {
			pos--;
		}
		return collection.get(pos);
	}

	// 前移
	public boolean hasPrevious() {
		if (pos > 0) {
			return true;
		} else {
			return false;
		}
	}
}
