package com.danwalkercs.notificationsevents.repository.data;

import com.danwalkercs.notificationsevents.domain.data.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {

}
