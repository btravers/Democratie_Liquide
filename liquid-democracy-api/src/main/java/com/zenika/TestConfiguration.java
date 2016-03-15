package com.zenika;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zenika.si.core.zenika.authentication.service.CollaboratorService;
import com.zenika.si.core.zenika.authentication.service.CollaboratorServiceStub;

@Configuration
@Profile({ "dev", "docker-test" })
public class TestConfiguration {

	@Bean
	public CollaboratorService collaboratorService() {
		return new CollaboratorServiceStub();
	}

}