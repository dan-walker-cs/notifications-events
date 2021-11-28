package com.danwalkercs.notificationsevents.events;

import com.danwalkercs.notificationsevents.domain.data.EmailNotification;
import com.danwalkercs.notificationsevents.domain.data.Information;
import com.danwalkercs.notificationsevents.service.EmailNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgencyResponseDueReminderListener {

    @Autowired
    private EmailNotificationService emailNotificationService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener
    void handleAgencyResponseDueReminderEvent(AgencyResponseDueReminderEvent event) {
        // this is where we take the list of 'reviews' and send a notification for each one
        List<EmailNotification> emailNotificationsToSend = event.getInformationList()
                .stream()
                .map((Information info) -> {
                    // build
                    EmailNotification emailNotification = emailNotificationService.buildEmailNotificationFromInformation(info, event.getName());
                    // send
                    try {
                        emailNotificationService.sendAgencyResponseDueReminderEmailNotification(emailNotification);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                    // return
                    return emailNotification;
                })
                .collect(Collectors.toList());

        logger.info("Agency Response Due Reminder Event handled.");
    }
}
