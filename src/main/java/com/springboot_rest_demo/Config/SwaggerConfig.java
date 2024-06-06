package com.springboot_rest_demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI cloudVendorOpenApi() {
		/*
		 * Contact contact= new Contact() .name("Praveen") .email("dummy@gmail.com");
		 */
		
		Info apiInfo = new Info()
				.title("Cloud Vendor API Application")
				.description("Cloud Vendor Documentation")
				//.contact(contact)
				.contact(new Contact().name("praveen").email("dummy1@gmail.com"))
				.version("1.0.0")
				.license(new License().name("dummy license").url("http://localhost:8080/"));
		return new OpenAPI().info(apiInfo);
	}
	
}
	
	/*@Bean   // old method where we used the lesser version(2.x.x) of springboot.
	public Docket customSwaggerImpl() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(pathSelectors.ant("/cloudvendor/*"))
				.apis(RequestHandlerSelectors.basePackage("com.springboot_rest_demo"))
				.build()
				.apiInfo(apiCustomData());
	}
	
	@Bean
	private ApiInfo apiCustomData() {
		return new ApiInfo(
				"Cloud Vendor API Application",
				"Cloud Vendor Documentation",
				"1.0.0",
				"Cloud Vendor Service Terms",
				new Contact("Praveen", "http://dummyurl.com","dummy@gmail.com"),
				"License of API", 
				"API license URL", 
				Collections.emptyList()
				);
			}	
				*/
	

	


