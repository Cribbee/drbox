package com.lxy11.drbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DrboxApplication {

	public static void main(String[] args){
			SpringApplication.run(DrboxApplication.class, args);
	}
}
