package com.example.demo.utils

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

// 2 ways that we setup


@Component
@Order(2) // Order does not work here but works for AppArgs2 which is defined using ApplicationRunner interface
class AppArgs(args: ApplicationArguments){

  init {
    // here we could setup things after spring boot app has been setup and before it starts accepting traffic
    println("###################### INITING AppArgs")
    val nonOptionArgs= args.nonOptionArgs
    nonOptionArgs.forEach {
      println(it)
    }
    args.optionNames.forEach {
      println("###### ARGS => $it = ${args.getOptionValues(it)}")
    }
  }
}

@Component
@Order(3)
class AppArgs2 : ApplicationRunner{


  override fun run(args: ApplicationArguments?) {
    // here we could setup things after spring boot app has been setup and before it starts accepting traffic
    println("###################### INITING AppArgs2")
    val nonOptionArgs= args?.nonOptionArgs
    nonOptionArgs?.forEach {
      println(it)
    }
    args?.optionNames?.forEach {
      println("###### ARGS => $it = ${args.getOptionValues(it)}")
    }
  }
}

