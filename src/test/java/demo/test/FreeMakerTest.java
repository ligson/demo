package demo.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMakerTest {
	@Test
	public void templateTest() {
		File file = new File(
				"./src/main/webapp/mailTemplate/ModifyPassword.html");

		Configuration configuration = new Configuration();
		try {
			configuration.setDirectoryForTemplateLoading(file.getParentFile());
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("username", "test");
			map.put("email", "test@ass.com");
			
			Template template = configuration.getTemplate(file.getName());
			
			File file2 = File.createTempFile("sss", "html");
			FileWriter fileWriter = new FileWriter(file2);
			template.process(map, fileWriter);
			fileWriter.close();
			
			System.out.println(FileUtils.readFileToString(file2));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
