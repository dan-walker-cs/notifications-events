package com.danwalkercs.notificationsevents.controllers.emailNotifications;

import com.danwalkercs.notificationsevents.domain.data.EmailNotification;
import com.danwalkercs.notificationsevents.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/emailNotifications")
public class EmailNotificationController {

    @Autowired
    private EmailNotificationService emailNotificationService;

    @RequestMapping(value="/all", method=RequestMethod.GET, produces="application/json;charset=utf-8")
    @ResponseBody
    public List<EmailNotification> retrieveAllEmailNotifications() {
        return emailNotificationService.retrieveAllEmailNotifications();
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    @ResponseStatus(code= HttpStatus.OK, reason="OK")
    @Transactional
    public void emailNotificationSave(@RequestBody EmailNotification emailNotification) {
        emailNotificationService.save(emailNotification);
    }
}
