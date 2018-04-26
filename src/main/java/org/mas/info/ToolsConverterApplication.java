package org.mas.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ToolsConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolsConverterApplication.class, args);
		
	}
	
}
