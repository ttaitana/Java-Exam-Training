package com.example.exam;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SampleConfig {
    @Bean
    public RestTemplate createRestTemplate(){
        RestTemplateBuilder rb = new RestTemplateBuilder();
        return rb.build();
    }
}
