package demo.service;

import java.util.Map;

import demo.domain.User;

public interface MailService {
	public void sendMail(User sender,User receiver,String template,Map<String, String> params);
}
