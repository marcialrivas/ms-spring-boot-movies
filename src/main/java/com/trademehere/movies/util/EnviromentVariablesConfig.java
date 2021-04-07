package com.trademehere.movies.util;

import java.util.HashMap;
import java.util.Map;

public class EnviromentVariablesConfig {

	public static Map<String, String> getElasctiAMPConfing(){
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.put("service_name", System.getenv("ELASTIC_APM_SERVICE_NAME"));
		configuration.put("server_urls", System.getenv("ELASTIC_APM_SERVERS_URL"));
		configuration.put("secret_token", System.getenv("ELASTIC_APM_SECRET_TOKEN"));
		configuration.put("application_packages", "com.trademehere.movies");
		configuration.put("environment", System.getenv("ELASTIC_APM_ENVIRONMENT"));
		configuration.put("enable_log_correlation","true");
		
		return configuration;
	}
}
