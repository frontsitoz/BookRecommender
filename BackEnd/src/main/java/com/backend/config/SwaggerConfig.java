package com.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Api Books",
                description = "Api Rest of Books",
                version = "1.0.0",
                contact = @Contact(
                        name = "Group 6",
                        url = "",
                        email = "osorioWilson089@gmail.com"
                ),
                license = @License(
                        name = "Standard Software Use License for Books",
                        url = "http://www.documents.com/licence"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:9090"
                )
        }
)
public class SwaggerConfig {
        public static final String description = "This controller allows registration, editing, creation, updating";
}
