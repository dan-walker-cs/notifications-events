package com.danwalkercs.notificationsevents.service;

import com.danwalkercs.notificationsevents.domain.data.EmailNotification;
import com.danwalkercs.notificationsevents.repository.data.EmailNotificationRepository;
import com.danwalkercs.notificationsevents.repository.data.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailNotificationService {

    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private EmailNotificationRepository emailNotificationRepository;

    public List<EmailNotification> retrieveAllEmailNotifications() {
        return emailNotificationRepository.findAll();
    }

    public EmailNotification save(EmailNotification emailNotification) {
        return emailNotificationRepository.save(emailNotification);
    }

    public void sendQuestionsEmailNotification(EmailNotification emailNotification) {

    }

    public void sendAgencyResponseDueReminderEmailNotification(EmailNotification emailNotification) {

    }
}
