package com.github.smartbooks.bootstrap.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RequestMapping("/RestTemplate")
@RestController
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/index")
    public String index() {

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("body data", headers);

        //调用第三方的API接口,很省事很方便
        return restTemplate.exchange("https://www.yiibai.com/spring-boot/spring_boot_rest_template.html", HttpMethod.GET, entity, String.class).getBody();
    }


    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();

    }

}
