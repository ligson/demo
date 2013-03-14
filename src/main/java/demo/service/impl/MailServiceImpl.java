package demo.service.impl;

import java.util.Map;

import demo.domain.User;
import demo.service.MailService;

public class MailServiceImpl implements MailService {

	@Override
	public void sendMail(User sender, User receiver, String template,
			Map<String, String> params) {

	}

}
