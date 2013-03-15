package demo.util;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;

import demo.mail.utils.MailConfig;

public class SystemInit implements InitializingBean {

	public static final String userdir = System.getProperty("user.home");
	public static final File demoRootDir = new File(userdir, ".demo");
	public static MailConfig mailConfig;
	static {
		if (!demoRootDir.exists()) {
			demoRootDir.mkdirs();
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		configH2db();
		configSys();
		System.out.println("http://127.0.0.1:8080/demo");
	}

	public void configH2db() throws Exception {
		File dbFile = new File(demoRootDir, "demodb");
		if (!dbFile.exists()) {
			dbFile.createNewFile();
		}
	}

	public void configSys() throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("demoConfig.properties");
		
		File resourceFile = classPathResource.getFile();
		File userConfig = new File(demoRootDir,resourceFile.getName());
		
		if(!userConfig.exists()){
			FileUtils.copyFile(resourceFile, userConfig);
		}
		mailConfig = MailConfig.getInstance(userConfig);
	}

}
