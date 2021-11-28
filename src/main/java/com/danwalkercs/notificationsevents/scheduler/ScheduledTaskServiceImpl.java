package com.danwalkercs.notificationsevents.scheduler;

import com.danwalkercs.notificationsevents.domain.data.Information;
import com.danwalkercs.notificationsevents.events.AgencyResponseDueReminderEvent;
import com.danwalkercs.notificationsevents.service.InformationListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService {

    @Autowired
    private InformationListingService infoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void retrieveReviewsWith7DaysUntilResponseDueDate() throws Exception {
        // logic in here to find all the stuff we want
        List<Information> informationList = infoService.retrieveAllInformation();
        publisher.publishEvent(new AgencyResponseDueReminderEvent(informationList));
    }
}
