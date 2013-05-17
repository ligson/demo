package demo.test;

import org.junit.Test;

public class StringTest {
	//@Test
	public void test(){
		String fileName = "asdfas.gif";
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		assert suffix==".gif";
	}
}
