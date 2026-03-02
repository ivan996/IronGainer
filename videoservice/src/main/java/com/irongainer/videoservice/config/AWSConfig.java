package com.irongainer.videoservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "aws.s3")
public class AWSConfig {

    private String bucketName;
    private String accessKey;
    private String secretKey;
}
