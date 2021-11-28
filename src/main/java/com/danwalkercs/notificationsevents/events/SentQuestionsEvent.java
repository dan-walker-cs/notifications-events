package com.danwalkercs.notificationsevents.events;

import com.danwalkercs.notificationsevents.domain.data.Information;

public class SentQuestionsEvent {

    private Information information;
    private static final String name = "Questions Sent";

    public SentQuestionsEvent(Information information) {
        super();
        this.information = information;
    }

    public Information getInformation() {
        return information;
    }

    public String getName() {
        return name;
    }
}
