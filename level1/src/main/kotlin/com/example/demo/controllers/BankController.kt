package com.example.demo.controllers

import com.example.demo.BankService
import org.springframework.web.bind.annotation.RestController

@RestController
class BankController(private val service: BankService) {
}