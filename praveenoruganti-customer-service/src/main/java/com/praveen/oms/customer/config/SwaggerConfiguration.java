package com.praveen.oms.customer.config;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("!test")
public class SwaggerConfiguration {

	@Bean
	public Docket configDock() {
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select()
				.apis(basePackage("com.praveen.oms.customer.controller")).paths(regex("/customerservice.*")).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Customer Service Swagger2 Api Documentation")
				.description("WELCOME TO SWAGGER CLIENT")
				.contact(new Contact("PRAVEEN ORUGANTI", "https://praveenoruganti.blogspot.com/",
						"praveenoruganti@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();
	}
}
