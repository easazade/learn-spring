package com.example.demo6.basic.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GeneralController {

  @GetMapping("/")
  fun index(): String {
    return "<h1>Spring Boot Practice Project</h1>"
  }

  @GetMapping("/hello")
  fun hello(@RequestParam(value = "name", defaultValue = "Who Ever You Are") name: String): String {
    return "Hellooo $name"
  }

}