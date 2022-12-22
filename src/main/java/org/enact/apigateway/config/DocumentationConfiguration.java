package org.enact.apigateway.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//
//import java.util.ArrayList;
//import java.util.List;
//
@Configuration
@OpenAPIDefinition
public class DocumentationConfiguration {
    ////    Migration from swagger2 to swagger-3
////https://springdoc.org/migrating-from-springfox.html
//
    @Autowired
    private RouteDefinitionLocator locator;

    @Autowired
    private SwaggerUiConfigParameters swaggerUiConfigParameters;

    @Bean
    public List<GroupedOpenApi> apis() {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
            String name = routeDefinition.getId().replaceAll("-service", "");
            GroupedOpenApi api = GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
//            GroupedOpenApi api = GroupedOpenApi.builder().group(name).pathsToMatch("/**/" + name).build();
            groups.add(api);
            swaggerUiConfigParameters.addGroup(name,name);
        });
        return groups;
    }
    /*
    @Bean
    public GroupedOpenApi paymentApi() {
        return GroupedOpenApi.builder().group("payment")
                .pathsToMatch("/payment/**").build();
    }
    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder().group("users")
                .pathsToMatch("/users/**").build();
    }*/
//
    //    https://springdoc.org/faq.html
//    @Bean
//    public OpenAPI springShopOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("Enact API")
//                        .description("Enact's OpenAPI sample application")
//                        .version("v0.0.1")
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("Enact Consolidated Documentation")
//                        .url("https://www.github.com/xyz"));
//    }
}
