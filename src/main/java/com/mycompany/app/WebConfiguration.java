package com.mycompany.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration(proxyBeanMethods = false)
public class WebConfiguration {

    //Spring RestClient
    @Bean
    RestClient restClient(RestClient.Builder builder) {
        return builder.build();
    }

}
