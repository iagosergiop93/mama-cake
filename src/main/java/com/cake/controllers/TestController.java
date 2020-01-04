package com.cake.controllers;

import com.cake.exceptions.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(produces = "application/json")
    @RequestMapping("/exception")
    public void testExceptionHandler() {
        throw new CustomException("testing exception handler");
    }

}
