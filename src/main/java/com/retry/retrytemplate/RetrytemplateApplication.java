package com.retry.retrytemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RetrytemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetrytemplateApplication.class, args);
	}

}
