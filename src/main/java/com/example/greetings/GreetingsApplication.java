package com.example.greetings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingsApplication {

    String greetings = "";

    public static void main(String[] args) {
        SpringApplication.run(GreetingsApplication.class, args);
    }

    @PostMapping("/greetings")
    public MyObject postGreetingsForUser(@RequestBody String name) {
        greetings = "Hello, " + name + "!";
        return new MyObject(greetings, true);
    }

    @GetMapping("/greetings")
    public MyObject getGreetings() {
        if (greetings.isEmpty()) {
            greetings = "Greetings not set yet!";
        }
        return new MyObject(greetings, true);
    }
}