package demo.test;

import java.util.UUID;

import org.junit.Test;

import demo.mail.utils.MailSenderInfo;
import demo.mail.utils.SimpleMailSender;

public class MailTest {
	
	
	public void sendMail(){
	    //这个类主要是设置邮件  
	      MailSenderInfo mailInfo = new MailSenderInfo();   
	      mailInfo.setMailServerHost("smtp.bjnja.com");   
	      mailInfo.setMailServerPort("25");   
	      mailInfo.setValidate(true);   
	      mailInfo.setUserName("libiaobiao@bjnja.com");   
	      mailInfo.setPassword("biao891222");//您的邮箱密码   
	      mailInfo.setFromAddress("libiaobiao@bjnja.com");   
	      mailInfo.setToAddress("786983759@qq.com");   
	      mailInfo.setSubject(UUID.randomUUID().toString());   
	      mailInfo.setContent("Hello ！"+UUID.randomUUID().toString());   
	         //这个类主要来发送邮件  
	      SimpleMailSender sms = new SimpleMailSender();  
	          sms.sendTextMail(mailInfo);//发送文体格式   
	          sms.sendHtmlMail(mailInfo);//发送html格式 
	          System.out.println("成功："+UUID.randomUUID().toString());
	}
	
	@Test
	public void send() {
		for(int i = 0;i<100;i++){
			sendMail();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
