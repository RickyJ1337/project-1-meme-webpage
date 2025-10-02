package com.example.project_1_meme_webpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.project_1_meme_webpage.*"})
public class Project1MemeWebpageApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project1MemeWebpageApplication.class, args);
	}

}
