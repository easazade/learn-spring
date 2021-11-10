package com.example.demo6

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Demo6Application {
  // for consume rest tutorial
//  @Bean
//  fun restTemplate(builder: RestTemplateBuilder) = builder.build()
//
//  @Throws(Exception::class)
//  @Bean
//  fun run(restTemplate: RestTemplate): CommandLineRunner {
//    return CommandLineRunner { args: Array<String> ->
//      val quote = restTemplate.getForObject(
//        "https://quoters.apps.pcfone.io/api/random", Quote::class.java
//      )
//      logger.info(quote.toString())
//    }
//  }
  // end of consume rest tutorial
}

fun main(args: Array<String>) {
  runApplication<Demo6Application>(*args)

}
