package com.example.demo.data.datasource

import com.example.demo.data.models.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

  private val banks = listOf(
    Bank("7856", 3.14, 1),
    Bank("1010", 17.0, 1),
    Bank("1234", 1.0, 1),
  )

  override fun getBanks(): Collection<Bank> = banks

  override fun getBank(accountNumber: String): Bank {
      return banks.first { it.accountNumber == accountNumber }
  }

}