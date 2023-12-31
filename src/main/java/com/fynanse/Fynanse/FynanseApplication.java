package com.fynanse.Fynanse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class FynanseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FynanseApplication.class, args);
	}
	@Bean
	public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setContentType("application/json");
		viewResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[] {"*.json"});
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}
}