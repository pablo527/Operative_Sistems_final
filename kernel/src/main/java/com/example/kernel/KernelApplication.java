package com.example.kernel;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class KernelApplication {

	public static void main(String[] args) throws Exception {
		Log log = LogFactory.getLog(KernelApplication.class);
		log.info("pepe");
		SpringApplication.run(KernelApplication.class, args);

	}

}
