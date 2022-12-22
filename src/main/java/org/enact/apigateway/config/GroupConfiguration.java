//package org.enact.apigateway.config;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import org.springdoc.core.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GroupConfiguration {
//
//    @Bean
//    public GroupedOpenApi UsersApi() {
//        return GroupedOpenApi.builder().group("users").pathsToExclude("/api/v2/**").pathsToMatch("**/user-docs").build();
//    }
//    @Bean
//    public GroupedOpenApi paymentApi() {
//        return GroupedOpenApi.builder().group("payment").pathsToExclude("/api/v2/**").pathsToMatch("**/payment-docs").build();
//    }
//
////    Okta security configuration that needs to be done
////    @Bean
////    public GroupedOpenApi adminApi() {
////        return GroupedOpenApi.builder().group("payment").pathsToExclude("/api/v1/**").pathsToMatch("/api/v2/**").build();
////    }
//
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI().components(new Components()).info(new Info().title("Consolidated Enact Microservices Swagger URI")
//                .contact(new Contact().name("Ashutosh Satapathy")).version("1.0.0"));
//    }
//
//}
