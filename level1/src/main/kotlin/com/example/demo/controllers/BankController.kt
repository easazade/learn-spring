package com.example.demo.controllers

import com.example.demo.BankService
import com.example.demo.data.models.Bank
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

  @ExceptionHandler(NoSuchElementException::class)
  fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> {
    return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
  }

  @ExceptionHandler(IllegalArgumentException::class)
  fun handleIllegalArgument(e: IllegalArgumentException): ResponseEntity<String> {
    return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
  }

  @GetMapping
  fun getBanks() = service.getBanks()

  @GetMapping("/{accountNumber}")
  fun getBank(@PathVariable accountNumber: String): Bank {
    return service.getBank(accountNumber)
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  fun addBank(@RequestBody bank: Bank) = service.addBank(bank)


  @PatchMapping("/{accountNumber}")
  fun updateBank(@RequestBody bank: Bank, @PathVariable accountNumber: String) = service.updateBank(accountNumber ,bank)

}