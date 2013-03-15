package demo.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import demo.domain.User;
import demo.mail.utils.MailConfig;
import demo.service.MailService;
import demo.util.SystemInit;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class MailServiceImpl implements MailService {

	private static final Log log = LogFactory.getLog(MailServiceImpl.class);

	private Template getTemplate(String name) {
		try {
			// 通过Freemaker的Configuration读取相应的ftl
			Configuration cfg = new Configuration();
			// 设定去哪里读取相应的ftl模板文件
			cfg.setClassForTemplateLoading(this.getClass(), "/mailTemplate");
			// 在模板文件目录中找到名称为name的文件
			Template temp = cfg.getTemplate(name);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void sendMail(User sender, User receiver, String template,
			Map<String, Object> params) {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		MailConfig mailConfig = SystemInit.mailConfig;
		// 设定mail server
		senderImpl.setHost(mailConfig.getMailServer());

		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);

		// 设置收件人，寄件人
		try {
			messageHelper.setTo(receiver.getEmail());
			messageHelper.setFrom(sender.getEmail());
			messageHelper.setSubject("测试HTML邮件！");
			Template template2 = getTemplate(template);

			File tmp = File.createTempFile("mail", "txt");
			FileWriter fileWriter = new FileWriter(tmp);
			template2.process(params, fileWriter);

			String result = FileUtils.readFileToString(tmp);
			// true 表示启动HTML格式的邮件
			messageHelper.setText(result, true);

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		senderImpl.setUsername(mailConfig.getUsername()); // 根据自己的情况,设置username
		senderImpl.setPassword(mailConfig.getPassword()); // 根据自己的情况, 设置password
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.timeout", "25000");
		senderImpl.setJavaMailProperties(prop);
		// 发送邮件
		senderImpl.send(mailMessage);

		log.info("邮件发送成功..");
	}

}
