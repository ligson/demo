package org.ligson.designmode.creation.prototype;

import java.io.IOException;

public class DeepPrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException,
			ClassNotFoundException, IOException {
		// 创建对象
		DeepPrototype pt = new DeepPrototype();
		pt.setStr("Hello World!");
		SerializableObject obj = new SerializableObject();
		pt.setObj(obj);
		
		// 浅复制
		DeepPrototype pt1 = (DeepPrototype) pt.clone();
		System.out.println("浅复制原对象str：" + pt.getStr());
		System.out.println("浅复制新对象str：" + pt1.getStr());
		System.out.println("浅复制原对象obj：" + pt.getObj());
		System.out.println("浅复制新对象obj：" + pt1.getObj());
		
		// 修改浅复制对象的值
		pt1.setStr("Hello China!");
		System.out.println("修改后浅复制原对象str：" + pt.getStr());
		System.out.println("修改后浅复制新对象str：" + pt1.getStr());
		System.out.println("修改后浅复制原对象obj：" + pt.getObj());
		System.out.println("修改后浅复制新对象obj：" + pt1.getObj());
		
		// 深复制
		DeepPrototype pt2 = (DeepPrototype) pt.deepClone();
		System.out.println("深复制原对象str：" + pt.getStr());
		System.out.println("深复制新对象str：" + pt2.getStr());
		System.out.println("深复制原对象obj：" + pt.getObj());
		System.out.println("深复制新对象obj：" + pt2.getObj());
		
		// 修改深复制对象的值
		pt2.setStr("Hello China!");
		System.out.println("修改后深复制原对象str：" + pt.getStr());
		System.out.println("修改后深复制新对象str：" + pt2.getStr());
		System.out.println("修改后深复制原对象obj：" + pt.getObj());;
		System.out.println("修改后深复制新对象obj：" + pt2.getObj());
	}
}
