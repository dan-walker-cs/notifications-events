package com.danwalkercs.notificationsevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NotificationsEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationsEventsApplication.class, args);
	}

}
