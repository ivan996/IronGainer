package com.irongainer.workoutservice.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "video")
@Getter
public class VideoConfiguration {

    private String url;
    private String endpoint;
}
