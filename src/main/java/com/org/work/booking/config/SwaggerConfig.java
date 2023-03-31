package com.org.work.booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select()
				.paths(PathSelectors.any()) 
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Ticket Booking System API")
				.description("Ticket Booking System API for assingment")
				.termsOfServiceUrl("no such conditions")
				.contact(new Contact("RahulSharma", "rahulsharma1781@gmail.com", "rahulsharma1781@gmail.com"))
				.license("Corporate Licence")
				.licenseUrl("Rahul Sharma").version("1.0").build();
	}
}
