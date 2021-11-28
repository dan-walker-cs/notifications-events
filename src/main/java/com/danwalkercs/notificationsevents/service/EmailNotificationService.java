package com.danwalkercs.notificationsevents.service;

import com.danwalkercs.notificationsevents.domain.data.EmailNotification;
import com.danwalkercs.notificationsevents.domain.data.Information;
import com.danwalkercs.notificationsevents.repository.data.EmailNotificationRepository;
import com.danwalkercs.notificationsevents.repository.data.InformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Calendar;
import java.util.List;

@Service
public class EmailNotificationService {

    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private EmailNotificationRepository emailNotificationRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<EmailNotification> retrieveAllEmailNotifications() {
        return emailNotificationRepository.findAll();
    }

    public EmailNotification buildEmailNotificationFromInformation(Information info, String eventType) {
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.setType(eventType);
        emailNotification.setTo("walkuhdan@gmail.com");
        emailNotification.setCc("gallahanm@gmail.com; walkuhdan@yahoo.com;");
        emailNotification.setSubject("Real Test: receiving Information entity with id: " + info.getId());
        emailNotification.setBody(info.getContent());
        emailNotification.setSent_dt(Calendar.getInstance().getTime());

        return emailNotification;
    }

    public EmailNotification save(EmailNotification emailNotification) {
        return emailNotificationRepository.save(emailNotification);
    }

    public void sendQuestionsEmailNotification(EmailNotification emailNotification) throws MessagingException {
        logger.info("Sending Sent Questions email notification to: " + emailNotification.getTo() + " with CC list: " + emailNotification.getCc());

        final Context ctx = new Context();

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message =
                new MimeMessageHelper(mimeMessage, true, "UTF-8"); // true = multipart
        message.setSubject(emailNotification.getSubject());
        message.setFrom("spring.email.system.test@gmail.com");
        message.setTo(emailNotification.getTo());
        message.setCc("gallahanm@gmail.com");

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.templateEngine.process("questions_email_template.html", ctx);
        message.setText(htmlContent, true);

        mailSender.send(mimeMessage);

        logger.info("Complete.");
    }

    public void sendAgencyResponseDueReminderEmailNotification(EmailNotification emailNotification) throws MessagingException {
        logger.info("Sending Agency Response Due Reminder email notification to: " + emailNotification.getTo() + " with CC list: " + emailNotification.getCc());

        final Context ctx = new Context();

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message =
                new MimeMessageHelper(mimeMessage, true, "UTF-8"); // true = multipart
        message.setSubject(emailNotification.getSubject());
        message.setFrom("spring.email.system.test@gmail.com");
        message.setTo(emailNotification.getTo());
        message.setCc("gallahanm@gmail.com");

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.templateEngine.process("reminder_email_template.html", ctx);
        message.setText(htmlContent, true);

        mailSender.send(mimeMessage);

        logger.info("Complete.");
    }
}
