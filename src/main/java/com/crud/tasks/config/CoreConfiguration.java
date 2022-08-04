package com.crud.tasks.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public GroupedOpenApi groupedOpenApi(){
        String pathsToMatch[] = {"/v1/tasks/**"};
        String packagesToScan[] = {"com.crud.tasks.controller"};
        return GroupedOpenApi.builder()
                .group("tasks")
                .pathsToMatch(pathsToMatch)
                .packagesToScan(packagesToScan)
                .build();
    }


}
