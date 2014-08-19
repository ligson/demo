package org.ligson.designmode.structure.adapter;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Enumeration;

/**
 * @author liuzhongbing
 * 使用了包装器模式
 */
public class Itermeration implements Enumeration<Object> {
	Iterator<Object> it;

	public Itermeration(Iterator<Object> it) {
		this.it = it;
	}

	public boolean hasMoreElements() {
		return it.hasNext();
	}

	public Object nextElement() throws NoSuchElementException {
		return it.next();
	}
}
