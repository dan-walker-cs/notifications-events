package com.danwalkercs.notificationsevents.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTaskComponent {

    @Autowired
    private ScheduledTaskService scheduledService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron="10 0 0 ? * *")
    public void retrieveReviewsWith7DaysUntilResponseDueDate() throws Exception {
        scheduledService.retrieveReviewsWith7DaysUntilResponseDueDate();
        logger.info("Scheduled task 'retrieveReviewsWith7DaysUntilResponseDueDate' executed!");
    }
}
