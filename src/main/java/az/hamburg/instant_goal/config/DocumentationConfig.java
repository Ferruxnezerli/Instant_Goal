package az.hamburg.instant_goal.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class DocumentationConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("Instant Goal")
                .version("0.0git git .1")
                .description("Bu API, futbol komandalarını, oyunçuları, matçları və statistikaları idarə etmək üçün nəzərdə tutulub.")
                .contact(new Contact()
                        .name("Fərrux Nəzərli")
                        .email("nzrlifrrux@gmail.com"))
        );
    }
}
