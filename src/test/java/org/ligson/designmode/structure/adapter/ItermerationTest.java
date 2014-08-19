package org.ligson.designmode.structure.adapter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class ItermerationTest {
	public static void main(String args[]) {
		// 创建Iterator对象
		List<Object> list = new ArrayList<Object>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		Iterator<Object> it = list.iterator();

		// 取得Enumeration对象
		Enumeration<Object> em = new Itermeration(it);
		while(em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
	}
}
