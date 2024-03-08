package com.students;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentsCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsCrudApplication.class, args);
		System.out.println("server is runing");
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
