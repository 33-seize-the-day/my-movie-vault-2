package com.example.mmv;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Hello, 詹雨珊製作的MyMovieVault is up and running!";
    }
}