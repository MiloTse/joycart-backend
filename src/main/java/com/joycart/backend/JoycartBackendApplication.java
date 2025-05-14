package com.joycart.backend;

import com.joycart.backend.config.ApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ApiProperties.class})
public class JoycartBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoycartBackendApplication.class, args);
	}

}
