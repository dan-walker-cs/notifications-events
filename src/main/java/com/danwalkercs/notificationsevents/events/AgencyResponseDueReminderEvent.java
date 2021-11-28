package com.danwalkercs.notificationsevents.events;

import com.danwalkercs.notificationsevents.domain.data.Information;

import java.util.List;

public class AgencyResponseDueReminderEvent {

    private List<Information> informationList;
    private static final String name = "Agency Response Due Reminder";

    public AgencyResponseDueReminderEvent(List<Information> informationList) {
        super();
        this.informationList = informationList;
    }

    public List<Information> getInformationList() {
        return informationList;
    }

    public String getName() {
        return name;
    }
    // aggregate additional event information - for this one specifically, we just need the review information so this is fine
}
