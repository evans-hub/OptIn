package com.apptivate.OptIn;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {})
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "30s")
public class OptInApplication {
private static final Logger LOGGGER= LoggerFactory.getLogger(OptInApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(OptInApplication.class, args);
		LOGGGER.info("Successfully started");
	}

}
