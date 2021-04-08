package com.trademehere.movies.util;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

@ExtendWith(SystemStubsExtension.class)
class EnviromentVariablesConfigTest {

	@SystemStub
	public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

	@Test
	void testGetElasctiAMPConfing() {
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("service_name"),"");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("server_urls"),"");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("secret_token"),"");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("environment"),"");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("enable_log_correlation"),"true");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("application_packages"),"com.trademehere.movies");
	}

	@Test
	void testGetElasctiAMPConfingWithStub() {
		environmentVariables.set("ELASTIC_APM_SERVICE_NAME", "SERVICE NAME");
		environmentVariables.set("ELASTIC_APM_SERVERS_URL", "http://localhost");
		environmentVariables.set("ELASTIC_APM_SECRET_TOKEN", "TOKEN");
		environmentVariables.set("ELASTIC_APM_ENVIRONMENT", "ENV");
		
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("service_name"),"SERVICE NAME");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("server_urls"),"http://localhost");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("secret_token"),"TOKEN");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("environment"),"ENV");
	}
}
