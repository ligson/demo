package demo.test;

import java.util.UUID;

import org.junit.Test;

import demo.mail.utils.MailSenderInfo;
import demo.mail.utils.SimpleMailSender;

public class MailTest {
	
	
	public void sendMail(){
	    //这个类主要是设置邮件  
	      MailSenderInfo mailInfo = new MailSenderInfo();   
	      mailInfo.setMailServerHost("smtpcloud.sohu.com");   
	      mailInfo.setMailServerPort("25");   
	      mailInfo.setValidate(true);   
	      mailInfo.setUserName("postmaster@www-pl.sendcloud.org");   
	      mailInfo.setPassword("NneeoBL0Fvjni05C");//您的邮箱密码   
	      mailInfo.setFromAddress("postmaster@www-pl.sendcloud.org");   
	      mailInfo.setToAddress("593949938@qq.com");   
	      mailInfo.setSubject(UUID.randomUUID().toString());   
	      mailInfo.setContent("Hello ！"+UUID.randomUUID().toString());   
	         //这个类主要来发送邮件  
	      SimpleMailSender sms = new SimpleMailSender();  
	          sms.sendTextMail(mailInfo);//发送文体格式   
	          //sms.sendHtmlMail(mailInfo);//发送html格式 
	          System.out.println("成功："+UUID.randomUUID().toString());
	}
	@Test
	public void send() {
		sendMail();
	}
}
