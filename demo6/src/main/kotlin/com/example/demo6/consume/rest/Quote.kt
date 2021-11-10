package com.example.demo6.consume.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(
  var type: String,
  var value: Value
)