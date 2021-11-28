package com.danwalkercs.notificationsevents.service;

import com.danwalkercs.notificationsevents.domain.data.Information;
import com.danwalkercs.notificationsevents.repository.data.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationSaveService {

    @Autowired
    InformationRepository repository;

    public Information save(Information information) {
        return repository.save(information);
    }
}
