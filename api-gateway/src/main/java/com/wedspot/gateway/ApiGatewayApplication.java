package com.wedspot.gateway;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;



@SpringBootApplication
public class ApiGatewayApplication {
//	@Autowired
//	RouteDefinitionLocator locator;
//
//	@PostConstruct
//	public void printRoutes() {
//		locator.getRouteDefinitions().subscribe(route ->
//				System.out.println("Loaded Route: " + route.getId()));
//	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
