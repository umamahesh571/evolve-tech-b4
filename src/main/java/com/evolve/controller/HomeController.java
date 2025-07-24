package com.evolve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "<h1>Master the art of modern software delivery with our industry-aligned DevOps course.<br>" +
               "Learn CI/CD, Docker, Kubernetes, Jenkins, Git, and cloud deployment from real-world use cases.<br>" +
               "Gain hands-on experience with tools used by top tech companies.<br>" +
               "Build, test, and deploy applications faster with automation and collaboration techniques.<br>" +
               "Get job-ready with projects, interview preparation, and certification support.</h1>";
    }
}