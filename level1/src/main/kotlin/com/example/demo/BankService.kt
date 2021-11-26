package com.example.demo

import com.example.demo.data.datasource.BankDataSource
import com.example.demo.data.models.Bank
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BankService(private val datasource: BankDataSource) {

  fun getBanks() = datasource.getBanks()

  fun getBank(accountNumber: String) = datasource.getBank(accountNumber)

  fun addBank(bank: Bank) = datasource.addBank(bank)

  fun updateBank(accountNumber: String, bank: Bank) = datasource.updateBank(accountNumber, bank)

  fun deleteBank(accountNumber: String) = datasource.deleteBank(accountNumber)

}