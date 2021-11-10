package com.example.demo6.consume.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Value(
  var id: Long,
  var quote: String,
)