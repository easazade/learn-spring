package com.example.demo.utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class MyBean(
  @Value("\${name}")
  private val name: String? = null,
) {
  init {
    println("################### $name")
  }
}