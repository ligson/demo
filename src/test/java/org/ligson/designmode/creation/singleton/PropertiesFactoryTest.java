package org.ligson.designmode.creation.singleton;

public class PropertiesFactoryTest {
	public static void main(String[] args) {
		PropertiesFactory factory = PropertiesFactory.getInstance();
		String pwd1 = factory.getConfig("admin");
		System.out.println(pwd1);
	}
}
