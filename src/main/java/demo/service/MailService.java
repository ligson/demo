package demo.service;

import java.util.Map;
import demo.domain.User;

/**
 * @author ligson
 * @Description: [发送邮件]
 */
public interface MailService {
	public void sendMail(User sender, User receiver, String template,
			Map<String, Object> params);
}
