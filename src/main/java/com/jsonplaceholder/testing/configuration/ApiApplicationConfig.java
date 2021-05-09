package com.jsonplaceholder.testing.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan("com.JsonPlaceholder.testing.*")
@PropertySources({
	@PropertySource(value = "properties/${environment}/application.properties")
})
public class ApiApplicationConfig {

}
