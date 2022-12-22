//package org.enact.apigateway.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
////@Hidden
//public class SwaggerConfigController {
//
//    @Autowired
//    private ApiDocEndpointsConfiguration apiDocEndpoints;
//
//    @GetMapping("/swagger-config.json")
//    public SwaggerUrlsConfig swaggerConfig() {
//        List<SwaggerUrlsConfig.SwaggerUrl> urls = apiDocEndpoints.getEndpoints()
//                .entrySet().stream().map(routeEntry -> {
//                    String name = routeEntry.getKey();
//                    return SwaggerUrlsConfig.SwaggerUrl.builder()
//                            .url(routeEntry.getValue().getGatewayPrefix()
//                                    + routeEntry.getValue().getServicePath())
//                            .name(name).build();
//                }).collect(Collectors.toList());
//        return new SwaggerUrlsConfig(urls);
//    }
//
//    public static class SwaggerUrlsConfig {
//
//        private List<SwaggerUrl> urls;
//
//        public static class SwaggerUrl {
//            private String url;
//            private String name;
//        }
//    }
//
//}
