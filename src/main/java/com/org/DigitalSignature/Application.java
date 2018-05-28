package com.org.DigitalSignature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;



@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	/**
	 * Main method of the application. This method
	 * starts application consumer, reads db schema
	 * and reads csv file data and stores in in-memory.
	 * @param  args  String array to take user input
	 * @throws  Exception
	 */
	public static void main(String[] args) throws Exception {

		System.out.println("Inside Application !!!");

		//start Spring boot application
		SpringApplication.run(Application.class, args);
	}


}
