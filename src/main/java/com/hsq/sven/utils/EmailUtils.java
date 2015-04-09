package com.hsq.sven.utils;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


/*author:huangshanqi
 *time  :2014年10月5日 下午9:43:20
 *email :hsqmobile@gmail.com
 */
public class EmailUtils {

	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;

	public MailSender getMailSender() {
		return mailSender;
	}

	//setter注入属性
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public SimpleMailMessage getSimpleMailMessage() {
		return simpleMailMessage;
	}

	//setter注入属性
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void sendMail(String subject, String content, String to) {
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setText(content);

		mailSender.send(simpleMailMessage);
	}

}
