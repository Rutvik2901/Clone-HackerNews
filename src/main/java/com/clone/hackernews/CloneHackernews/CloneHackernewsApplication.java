package com.clone.hackernews.CloneHackernews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CloneHackernewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneHackernewsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("http://localhost:3000","https://hackernews-clone-rutvik.herokuapp.com")
						.allowedMethods(HttpMethod.GET.toString(),HttpMethod.POST.toString(),HttpMethod.PUT.toString(),HttpMethod.DELETE.toString(), HttpMethod.OPTIONS.toString());
			}
		};
	}
}
