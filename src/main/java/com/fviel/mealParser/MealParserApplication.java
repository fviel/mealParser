package com.fviel.mealParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MealParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealParserApplication.class, args);
	}
}
