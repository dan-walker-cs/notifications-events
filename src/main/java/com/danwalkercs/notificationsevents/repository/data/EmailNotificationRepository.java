package com.danwalkercs.notificationsevents.repository.data;

import com.danwalkercs.notificationsevents.domain.data.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long> {
}
