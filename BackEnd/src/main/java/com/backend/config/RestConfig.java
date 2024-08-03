package com.backend.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestConfig {

    //    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
//        return restTemplate;
//    }
    @Bean(name = "restTemplateGson")
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter(gson()));
        return restTemplate;
    }
    @Bean
    public Gson gson() {
        return new Gson();
    }

//    @Bean(name = "restTemplate")
//    public RestTemplate restTemplate() {
//
//        return new RestTemplate();
//    }
}
