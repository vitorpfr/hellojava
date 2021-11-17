package com.example.loginandregistrationdemo.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor

public class EmailService implements EmailSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private static final String EMAIL_FROM = "hello@amigoscode.com";
    private static final String EMAIL_SUBJECT = "Confirm your e-mail";
    private static final String EMAIL_SEND_FAILED_MSG = "Failed to send e-mail";
    private final JavaMailSender mailSender;

    // maildev was used here to test the functionality (https://github.com/maildev/maildev)

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject(EMAIL_SUBJECT);
            helper.setFrom(EMAIL_FROM);

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            LOGGER.error(EMAIL_SEND_FAILED_MSG, e);
            throw new IllegalStateException(EMAIL_SEND_FAILED_MSG);
        }
    }
}
