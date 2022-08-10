package com.nabil.SystemRecrutement.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.nabil.SystemRecrutement.util.Constants.APP_ROOT;


@Configuration
//c'est une annotation qui permet dir qui on veut acitver swagger
@EnableSwagger2

public class SwaggerConfiguration {
	
	
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(
						new ApiInfoBuilder()
						.description("System du Recrutement  API documentation")
						.title("System du Recrutement ")
						.build()
						
						)
				.groupName("REST API V1")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nabil.SystemRecrutement"))
				.paths(PathSelectors.ant(APP_ROOT + "/**"))
				.build();
	}
	
	
	


}
