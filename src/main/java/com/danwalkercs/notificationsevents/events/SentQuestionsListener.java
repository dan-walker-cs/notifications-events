package com.danwalkercs.notificationsevents.events;

import com.danwalkercs.notificationsevents.domain.data.EmailNotification;
import com.danwalkercs.notificationsevents.service.EmailNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class SentQuestionsListener {

    @Autowired
    private EmailNotificationService emailNotificationService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener
    void handleSentQuestionsEvent(SentQuestionsEvent event) {
        EmailNotification emailNotification = emailNotificationService.buildEmailNotificationFromInformation(event.getInformation(), event.getName());
        try {
            emailNotificationService.sendQuestionsEmailNotification(emailNotification);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        logger.info("Sent Questions Event handled.");
    }
}
