package com.coffee.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@PropertySource("classpath:swagger.properties")
@EnableSwagger2
@ComponentScan("com.coffee.house")
public class CoffeHouseApplication {

	private static final String SWAGGER_API_VERSION = "2.0";
	private static final String SWAGGER_LICENSE = "Swagger License";
	private static final String SWAGGER_TITLE = "Coffee House REST APIs";
	private static final String SWAGGER_DESCRIPTION = "Details about Rest APIs used in Coffee House";
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title(SWAGGER_TITLE).description(SWAGGER_DESCRIPTION).license(SWAGGER_LICENSE).version(SWAGGER_API_VERSION).build();
	}
	
	@Bean
	public Docket productsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).pathMapping("/").select().paths(PathSelectors.regex("/coffeeHouse.*")).build();
	}
	
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(CoffeHouseApplication.class, args);
	}
}
