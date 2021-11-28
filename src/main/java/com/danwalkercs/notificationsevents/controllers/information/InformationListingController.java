package com.danwalkercs.notificationsevents.controllers.information;

import com.danwalkercs.notificationsevents.domain.data.Information;
import com.danwalkercs.notificationsevents.service.InformationListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listing/information")
public class InformationListingController {

    @Autowired
    InformationListingService infoService;

    @RequestMapping(value="/all", method=RequestMethod.GET, produces="application/json;charset=utf-8")
    @ResponseBody
    public List<Information> retrieveAllInformation() {
        return infoService.retrieveAllInformation();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json;charset=utf-8")
    @ResponseBody
    public Information retrieveInformationById(@PathVariable(value="id") final Long id) {
        return infoService.retrieveInformationById(id);
    }
}
