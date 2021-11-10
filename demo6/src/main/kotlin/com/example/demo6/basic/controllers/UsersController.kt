package com.example.demo6.basic.controllers

import com.example.demo6.basic.models.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController {

  var counter: Long = 0

  @GetMapping("/users")
  fun users(): List<User> {
    counter++
    return listOf(
      User(
        id = counter,
        firstname = "alireza",
        lastname = "easazade",
      )
    )
  }

}