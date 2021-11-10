package com.example.demo6.accessing.data.jpa

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(val repository: CustomerRepository) {

  @GetMapping("/customers")
  fun createCustomers(
    @RequestParam(name = "firstname", required = false) firstName: String?,
    @RequestParam(name = "lastname", required = false) lastname: String?,
  ): Any {
    return if (firstName != null && lastname != null) {
      val customer = repository.save(Customer(firstName = firstName, lastName = lastname, id = null))
      customer
    } else {
      return repository.findAll()
    }
  }

  @GetMapping("/customers/{id}")
  fun getCustomerById(@PathVariable id: Long) = repository.findById(id)

  @GetMapping("/customers/search")
  fun getCustomersByLastName(@RequestParam("search", defaultValue = "") search: String) = repository.findByLastName(search)

}