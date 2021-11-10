package com.example.demo6.accessing.data.jpa

import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {
  fun findByLastName(lastName: String): List<Customer>


}