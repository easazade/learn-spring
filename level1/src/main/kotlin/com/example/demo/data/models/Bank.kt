package com.example.demo.data.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Bank(
  // @JsonProperty is useful for when we need to get this data not from database bu another server using RestTemplate
  @JsonProperty("account_number")
  val accountNumber: String,

  val trust: Double,

  @JsonProperty("default_transaction_fee")
  val transactionFee: Int,
)