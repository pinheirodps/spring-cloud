package com.jps.example.usergreetingservice.controller;

import com.jps.example.usergreetingservice.consumer.GreetingConsumer;
import com.jps.example.usergreetingservice.service.UserGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class UserGreetingController {

    private final UserGreetingService service;

    @Autowired
    public UserGreetingController(UserGreetingService service) {
        this.service = service;
    }

    @GetMapping("/{username}")
    public String sayHello(@PathVariable String username) {
        return service.sayHelloToUser(username);
    }

}
