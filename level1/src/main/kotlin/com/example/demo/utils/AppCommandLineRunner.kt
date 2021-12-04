package com.example.demo.utils

import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(1)
class AppCommandLineRunner : CommandLineRunner {
  override fun run(vararg args: String?) {
    // we could run some code here once spring app is started
    println("############## running AppCommandLineRunner")
    println("############## $args")
  }
}