package demo.mail.utils;

public class MailConfig {
	private String mailServer;
	private int port;
	private String username;
	private String password;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
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
