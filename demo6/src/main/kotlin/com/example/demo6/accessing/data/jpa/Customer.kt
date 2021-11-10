package com.example.demo6.accessing.data.jpa

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
class Customer(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long?,
  var firstName:String,
  var lastName:String,
)