package EmployeeAPI.EmployeeAPI.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        info = @Info(
                       title = "employee details API",
                       description = "This is Employee details project api developed by somya",
                       version = "1.0",
                       contact = @Contact(
                                   name = "somya",email = "somyasimmi111@gmail.com" ,url = "somya.com"),
                       license = @License( name = "Apache")
        ),
                servers = {
                        @Server(
                description = "Dev",
                url = "http://localhost:8080"
        ),

        @Server(
                description = "Test",
                url = "http://localhost:8080"
        ),
},
        security = @SecurityRequirement(
                name = "auth"
        )


)

@SecurityScheme(
        name = "auth",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = "Security desc"
)



public class SwaggerApplication {
}
