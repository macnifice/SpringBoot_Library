package com.library.library_rest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
            description = "OpenApi documentation for spring security",
                title = "OpenApi specification - Luis Chavez",
                version = "1.0.0"
        ),
        servers = @Server(
                description = "local env",
                url = "http://localhost:8080"
        )

)
public class OpenApiConfig {
}
