package org.ligson.designmode.structure.adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumeratorTest {

	public static void main(String[] args) {
		// 创建Enumeration对象
		Vector<Object> vect = new Vector<Object>();
		vect.add("aaa");
		vect.add("bbb");
		vect.add("ccc");
		Enumeration<Object> em = vect.elements();

		// 取得Iterator对象
		Iterator<Object> it = new Enumerator(em);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
