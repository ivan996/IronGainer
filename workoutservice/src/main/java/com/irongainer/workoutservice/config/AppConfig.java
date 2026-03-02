package com.irongainer.workoutservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final VideoConfiguration videoConfiguration;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(videoConfiguration.getUrl()).build(); // Replace with videoservice URL
    }
}
