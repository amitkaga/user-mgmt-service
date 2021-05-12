package com.example.usermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User Mgmt Service", version = "1.0-SNAPSHOT"))
public class UsermgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermgmtApplication.class, args);
	}

}
