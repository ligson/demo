package demo.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;

import demo.dao.util.DBConfig;
import demo.mail.utils.MailConfig;

public class SystemInit extends ContextLoaderListener implements
		ServletContextListener, InitializingBean {

	public static final String userdir = System.getProperty("user.home");
	public static final File demoRootDir = new File(userdir, ".demo");
	public static String webappPath;
	private static final File dbFile;
	private static final File userConfig;
	private Log log = LogFactory.getLog(SystemInit.class);
	static {
		if (!demoRootDir.exists()) {
			demoRootDir.mkdirs();
		}

		dbFile = new File(demoRootDir, "demodb");
		if (!dbFile.exists()) {
			try {
				dbFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ClassPathResource classPathResource = new ClassPathResource(
				"demoConfig.properties");

		File resourceFile = null;
		try {
			resourceFile = classPathResource.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		userConfig = new File(demoRootDir, resourceFile.getName());

		if (!userConfig.exists()) {
			try {
				FileUtils.copyFile(resourceFile, userConfig);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setWebRootPath();
		log.info("server url: http://127.0.0.1:8080/demo");
		log.info("webservices address: http://localhost:8080/demo/services/demoUserService?wsdl");
	}

	public void setWebRootPath() {
		String u = this.getClass().getResource("/").getPath();
		File file = new File(u).getParentFile().getParentFile();
		webappPath = file.getAbsolutePath();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("spring startup");
	}

}
