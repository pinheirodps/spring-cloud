package com.jps.example.usergreetingservice.consumer;

import com.jps.example.usergreetingservice.service.EurekaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class GreetingConsumer {

    private final RestTemplate restTemplate;


    @Value("${app.greetingService.serviceId}")
    private String greetingServiceId;

    @Value("${app.greetingService.endpoint.greeting}")
    private String greetingEndpointUri;

    @Autowired
    public GreetingConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getRandomGreeting() {
        URI uri = eurekaService.getInstance(greetingServiceId);
        String greeting = restTemplate.getForObject(uri.toString() + greetingEndpointUri, String.class);
        return greeting;
    }
}
