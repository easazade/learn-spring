package com.example.demo

import com.example.demo.data.datasource.BankDataSource
import org.springframework.stereotype.Service

@Service
class BankService(private val datasource: BankDataSource) {

  fun getBanks() = datasource.getBanks()

  fun getBank(accountNumber: String) = datasource.getBank(accountNumber)

}