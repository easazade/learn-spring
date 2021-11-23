package com.example.demo.controllers

import com.example.demo.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

  @GetMapping
  fun getBanks() = service.getBanks()

}