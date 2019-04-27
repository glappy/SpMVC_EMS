package com.biz.email.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.biz.email.model.MailVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SendMailService {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	ServletContext context;
	
	public void sendMail(MailVO mailVO) {

		String from_email = mailVO.getFrom_email();
		String to_email = mailVO.getTo_email();
		String subject = mailVO.getS_subject();
		String content = mailVO.getS_content();
		String file1 = mailVO.getS_file1();

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper mHelper;
		try {
			mHelper = new MimeMessageHelper(message, true, "UTF-8");
			mHelper.setFrom(from_email);
			mHelper.setTo(to_email);
			mHelper.setSubject(subject);
			mHelper.setText(content, true);

			FileSystemResource fr = new FileSystemResource(context.getRealPath("/files/") + file1);
			mHelper.addAttachment(file1, fr);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}