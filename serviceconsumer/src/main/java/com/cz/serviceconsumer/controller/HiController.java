package com.cz.serviceconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class HiController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/hello")
    public String hi() {
        return restTemplate.getForObject("http://ZONE-DEMO/hi", String.class);
    }
}
