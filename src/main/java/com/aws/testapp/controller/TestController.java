package com.aws.testapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private Environment environment;

    @GetMapping("/appname")
    public ResponseEntity<Map<String, String>> getAppName(){
        return ResponseEntity.ok(new HashMap<>() {
            {
                put("appname", environment.getProperty("spring.application.name"));
            }
        });
    }
}
