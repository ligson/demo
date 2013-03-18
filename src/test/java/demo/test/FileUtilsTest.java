package demo.test;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class FileUtilsTest {
	public static void main(String[] args) throws Exception{
		File file = new File("./src/main/webapp/mailTemplate/ModifyPassword.html");
		System.out.println(file.getAbsolutePath());
		String string = FileUtils.readFileToString(file);
		System.out.println(string);
	}
}
