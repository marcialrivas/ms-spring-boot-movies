package com.trademehere.movies.util;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



class EnviromentVariablesConfigTest {


	@Test
	void testGetElasctiAMPConfing() {
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("service_name"),"");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("server_urls"),"");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("secret_token"),"");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("environment"),"");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("enable_log_correlation"),"true");
		assertEquals(EnviromentVariablesConfig.getElasctiAMPConfing().get("application_packages"),"com.trademehere.movies");
	}

}
