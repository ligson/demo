package demo.test;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMailExample {

	private static final String SENDCLOUD_SMTP_HOST = "smtpcloud.sohu.com";
	private static final int SENDCLOUD_SMTP_PORT = 25;

	/**
	 * @param args
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws MessagingException,
			UnsupportedEncodingException {
		// 配置javamail
		Properties props = System.getProperties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", SENDCLOUD_SMTP_HOST);
		props.put("mail.smtp.port", SENDCLOUD_SMTP_PORT);
		props.setProperty("mail.smtp.auth", "true");
		// 控制连接和socket timeout 时间
		props.put("mail.smtp.connectiontimeout", 1800);
		props.put("mail.smtp.timeout", 6000);

		props.setProperty("mail.mime.encodefilename", "true");

		// 认证的用户和密码， 不同于登录站点的用户名和密码，需要登录SendCloud进行发信域名获取
		final String userName = "postmaster@www-pl.sendcloud.org";
		final String password = "NneeoBL0Fvjni05C";

		Session mailSession = Session.getInstance(props, new Authenticator() {
			// 用户验证
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		// 设置调试，打印smtp信息
		// session.setDebug(true);

		Transport transport = mailSession.getTransport();
		MimeMessage message = new MimeMessage(mailSession);
		Multipart multipart = new MimeMultipart("alternative");

		// 纯文本形式的邮件正文
		// BodyPart part1 = new MimeBodyPart();
		// part1.setText("欢迎使用SendCloud", "text/plain;charset=UTF-8");
		// part1.setHeader("Content-Type", "text/plain;charset=UTF-8");
		// part1.setHeader("Content-Transfer-Encoding", "base64");

		// html形式的邮件正文
		BodyPart part2 = new MimeBodyPart();
		part2.setHeader("Content-Type", "text/html;charset=UTF-8");
		part2.setHeader("Content-Transfer-Encoding", "quoted-printable"); // 或者使用base64
		part2.setContent("欢迎使用SendCloud", "text/html;charset=UTF-8");

		// multipart.addBodyPart(part1);
		multipart.addBodyPart(part2);

		message.setContent(multipart);
		// message.setFrom(new InternetAddress("from@sendcloud.org"));
		message.setFrom(new InternetAddress("593949938@qq.com",
				"SendCloud管理员", "UTF-8"));
		message.setSubject("主题--欢迎使用SendCloud", "UTF-8");
		message.addRecipient(javax.mail.Message.RecipientType.TO,
				new InternetAddress("924832818@qq.com"));

		transport.connect();
		transport.sendMessage(message,
				message.getRecipients(javax.mail.Message.RecipientType.TO));
		transport.close();
	}

}
