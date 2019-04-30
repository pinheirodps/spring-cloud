package com.jps.example.usergreetingservice.consumer;

import com.jps.example.usergreetingservice.service.EurekaService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "getDefaultGreeting")
    public String getRandomGreeting() {
        String greeting = restTemplate.getForObject("http://greeting-service" + greetingEndpointUri, String.class);
        return greeting;
    }

    public String getDefaultGreeting() {
        return "Good bye";
    }
}
