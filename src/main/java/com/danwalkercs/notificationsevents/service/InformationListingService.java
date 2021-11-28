package com.danwalkercs.notificationsevents.service;

import com.danwalkercs.notificationsevents.domain.data.Information;
import com.danwalkercs.notificationsevents.repository.data.InformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformationListingService {

    @Autowired
    private InformationRepository repository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<Information> retrieveAllInformation() {
        logger.info("InformationListingService retrieving all Information from table..");
        return repository.findAll();
    }

    public Information retrieveInformationById(Long id) {
        Optional<Information> targetInfo =repository.findById(id);

        return targetInfo.get();
    }
}
