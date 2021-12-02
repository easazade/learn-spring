package com.example.demo

import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Level1Application

fun main(args: Array<String>) {
  // The constructor arguments passed to SpringApplication are configuration sources for Spring beans.
  // In most cases, these are references to @Configuration classes, but they could also be direct references @Component classes.
  // meaning if we have @Configurations that adds other beans to our application we should add them as vararg arguments to
  // our SpringApplication constructor. also externalized configuration is possible through application.properties file
  println("STARTING")
  val app = SpringApplication(Level1Application::class.java)
  // app.setBannerMode(Banner.Mode.OFF)
  app.run(*args)
}
