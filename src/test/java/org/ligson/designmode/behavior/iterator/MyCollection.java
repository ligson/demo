package org.ligson.designmode.behavior.iterator;

public class MyCollection implements Collection {
	public String str[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
			"X", "Y", "Z" };

	@Override
	public Iterator iterator() {
		return new MyIterator(this);
	}

	public Object get(int i) {
		return str[i];
	}

	public int size() {
		return str.length;
	}

}
