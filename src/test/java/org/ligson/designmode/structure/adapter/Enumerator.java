package org.ligson.designmode.structure.adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class Enumerator implements Iterator<Object> {
	Enumeration<Object> em;
	
	public Enumerator(Enumeration<Object> em) {
		super();
		this.em = em;
	}

	public boolean hasNext() {
		return em.hasMoreElements();
	}

	public Object next() {
		return em.nextElement();
	}

	public void remove() {
		
	}
}
