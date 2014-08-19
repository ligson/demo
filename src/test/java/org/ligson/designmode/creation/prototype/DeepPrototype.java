package org.ligson.designmode.creation.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author liuzhongbing
 * 原型模式
 */
public class DeepPrototype implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String str;
	private SerializableObject obj;
	
	/**
	 * 浅复制
	 */
	public Object clone() throws CloneNotSupportedException {
		DeepPrototype prototype = (DeepPrototype) super.clone();
		return prototype;
	}
	
	/**
	 * 深复制
	 */
	public Object deepClone() throws IOException, ClassNotFoundException {
		// 写入当前对象的二进制流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		// 读出二进制流产生新的对象
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public SerializableObject getObj() {
		return obj;
	}

	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}
}

class SerializableObject implements Serializable {
	private static final long serialVersionUID = 1L;
}
