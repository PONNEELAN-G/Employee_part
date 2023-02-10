package com.gl.emwa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket employeeApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Employee-API")
				.select().apis(RequestHandlerSelectors.basePackage("com.gl.emwa.controller"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Employee Api")
				.description("Employee API reference for developers")
				.termsOfServiceUrl("http://fakeEmployee.com")
				.contact(new springfox.documentation.service.Contact("Employee API", "http://fakeEmployee.com", "fakeEmployee@gmail.com"))
				.license("Employee License")
				.licenseUrl("http://fakeEmployee.com")
				.version("1.0")
				.build();
	}

}
