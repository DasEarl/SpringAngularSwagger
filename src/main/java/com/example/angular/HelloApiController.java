package com.example.angular;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Hello")
@RequestMapping("/api")
public class HelloApiController {

    @GetMapping("/helloWorld")
    public HelloEntity helloWorld() {
        return new HelloEntity();
    }

    @GetMapping("/hello/{name}")
    public String test(@PathVariable String name) {
        return "HelloApiController " + name;
    }
}
