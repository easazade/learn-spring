package com.example.demo.utils

import org.springframework.boot.ApplicationArguments
import org.springframework.stereotype.Component

@Component
class AppArgs(args: ApplicationArguments) {

  init {
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