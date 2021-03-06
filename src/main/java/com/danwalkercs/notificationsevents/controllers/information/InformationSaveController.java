package com.danwalkercs.notificationsevents.controllers.information;

import com.danwalkercs.notificationsevents.domain.data.Information;
import com.danwalkercs.notificationsevents.events.SentQuestionsEvent;
import com.danwalkercs.notificationsevents.service.InformationSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/information")
public class InformationSaveController {

    @Autowired
    InformationSaveService infoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @RequestMapping(value="/save", method= RequestMethod.POST)
    @ResponseStatus(code= HttpStatus.OK, reason="OK")
    @Transactional
    public void informationSave(@RequestBody Information information) {
        infoService.save(information);
    }

    @RequestMapping(value="/send", method= RequestMethod.POST)
    @ResponseStatus(code= HttpStatus.OK, reason="OK")
    @Transactional
    public void informationSend(@RequestBody Information information) {
        //infoService.update(information);
        publisher.publishEvent(new SentQuestionsEvent(information));
    }
}
