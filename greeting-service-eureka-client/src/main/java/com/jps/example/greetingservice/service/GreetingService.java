package com.jps.example.greetingservice.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class GreetingService {

    private List<String> greetings = Arrays.asList("Hi", "Hello", "Hey");

    public String getGreeting() {
        Random random = new Random();
        int randomIndex = random.nextInt(greetings.size());
        return greetings.get(randomIndex);
    }

}
