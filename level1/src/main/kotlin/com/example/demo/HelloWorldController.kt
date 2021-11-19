package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

//@RestController
@RequestMapping("api/v1")
class HelloWorldController {

  @GetMapping("/hello")
  fun hello() = "<h1>Hello World!</h1>"

  @GetMapping("/bye")
  fun bye() = "<h1>Good Bye!</h1>"

  @GetMapping("/whatsup")
  fun whatsup() = "<h1>Whats Up!</h1>"

}