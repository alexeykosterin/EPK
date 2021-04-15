package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="todo")
@Data
public class RestClientProperties {
    private String url;
    private String basePath;
}
