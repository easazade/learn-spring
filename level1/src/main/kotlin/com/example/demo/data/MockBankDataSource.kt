package com.example.demo.data

import com.example.demo.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSrouce {

  private val banks = listOf(
    Bank("7856", 3.14, 1),
    Bank("1010", 17.0, 1),
    Bank("2309", 1.0, 1),
  )

  override fun getBanks(): Collection<Bank> = banks

}