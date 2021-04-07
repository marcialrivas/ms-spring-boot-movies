package com.trademehere.movies.util;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

@ExtendWith(SystemStubsExtension.class)
class EnviromentVariablesConfigTest {

	@SystemStub
	public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

	@BeforeEach
	void setUp() throws Exception {
		environmentVariables.set("ELASTIC_APM_SERVICE_NAME", "SERVICE NAME");
		environmentVariables.set("ELASTIC_APM_SERVERS_URL", "http://localhost");
		environmentVariables.set("ELASTIC_APM_SECRET_TOKEN", "TOKEN");
		environmentVariables.set("ELASTIC_APM_ENVIRONMENT", "ENV");
	}

	@Test
	void testGetElasctiAMPConfing() {
		System.out.println(EnviromentVariablesConfig.getElasctiAMPConfing());
		assertTrue(EnviromentVariablesConfig.getElasctiAMPConfing().containsValue("TOKEN"));
	}

}
