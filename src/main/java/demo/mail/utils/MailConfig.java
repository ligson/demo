package demo.mail.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MailConfig {
	private String mailServer;
	private int port;
	private String username;
	private String password;

	public static MailConfig mailConfig;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public static synchronized MailConfig getInstance(File configFile) throws IOException{
		if (mailConfig == null) {
			mailConfig = new MailConfig();
		}
		Properties properties = new Properties();
		properties.load(new FileInputStream(configFile));
		mailConfig.setMailServer(properties.getProperty("mailServer"));
		mailConfig.setPort(Integer.parseInt(properties.getProperty("port")));
		mailConfig.setUsername(properties.getProperty("username"));
		mailConfig.setPassword(properties.getProperty("password"));
		return mailConfig;
	}

	private MailConfig() {

	}

	public String getMailServer() {
		return mailServer;
	}

	public void setMailServer(String mailServer) {
		this.mailServer = mailServer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
