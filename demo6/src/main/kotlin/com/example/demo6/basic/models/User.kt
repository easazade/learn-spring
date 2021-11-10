package com.example.demo6.basic.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "user")
@Table(name = "users")
class User(
  @Id @GeneratedValue var id: Long? = null,
  var firstname: String,
  var lastname: String,
)